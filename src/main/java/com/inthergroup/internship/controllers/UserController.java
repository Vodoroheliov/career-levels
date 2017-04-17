package com.inthergroup.internship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inthergroup.internship.models.CareerLevel;
import com.inthergroup.internship.models.Group;
import com.inthergroup.internship.models.User;
import com.inthergroup.internship.services.CareerLevelService;
import com.inthergroup.internship.services.GroupService;
import com.inthergroup.internship.services.TodoService;
import com.inthergroup.internship.services.UserService;

/**
 * A class to test interactions with the MySQL database using the UserDao class.
 *
 * @author interns
 */
@Controller
public class UserController {

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Autowired
    private UserService userService;

    @Autowired
    private CareerLevelService careerLevelService;
    
    @Autowired
    private TodoService todoService;
    
    @Autowired
    private GroupService groupService;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    @RequestMapping("/users/all-users")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("careerLevels", careerLevelService.findAll());
        model.addAttribute("groups", groupService.findAll());
        return "/users/all-users";
    }

    @RequestMapping("/users/progress-page/{id}")
    public String progressPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("userId", id);
        model.addAttribute("todos", todoService.findCurrentTodosByUserId(id));
        model.addAttribute(
                "finishedTodos", todoService.findCurrentFinishedTodosByUserId(id));
        model.addAttribute("user", userService.findById(id));
        model.addAttribute(
                "careerLevel", careerLevelService.findCareerLevelByUserId(id));
        model.addAttribute("todoTypes", todoService.findAllTodoTypes());
        return "users/progress-page";
    }

    @RequestMapping("/users/total-progress/{id}")
    public String total_progress(@PathVariable("id") Long id, Model model) {
        model.addAttribute("userId", id);
        model.addAttribute(
                "allFinishedTodos", todoService.findAllFinishedTodosByUserId(id));
        model.addAttribute("user", userService.findById(id));
        model.addAttribute(
                "careerLevel", careerLevelService.findCareerLevelByUserId(id));
        return "users/total-progress";
    }
    
    @RequestMapping("/promote-user")
    public String promoteUser(Long userId) {
        try {
            User user = userService.findById(userId);
            Long careerLevelId = user.getCareerLevel().getId();
            careerLevelId++; // increment for next level
            CareerLevel careerLevel = careerLevelService.findById(careerLevelId);
            
            if (careerLevel != null) {
                user.setCareerLevel(careerLevel);
                userService.edit(user);
            }
        } catch(Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error promoting the user: " + ex.toString();
        }
        
        return "redirect:/users/progress-page/" + userId;
    }

    /**
     * /create  --> Create a new user and save it in the database.
     * 
     * @return A string describing if the user is succesfully created or not.
     */
    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public String createUser(
            String lastName, String firstName, String username, String password,
            String email, Long careerLevelId, Long groupId) {
        
        User user = null;
        try {
            CareerLevel careerLevel = careerLevelService.findById(careerLevelId);
            Group group = groupService.findById(groupId);
            user = new User(lastName, firstName, username, password, email,
                    careerLevel, group);
            userService.create(user);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error creating the user: " + ex.toString();
        }
//        return "User succesfully created! (id = " + user.getId() + ")";
        return "redirect:/users/all-users";
    }

    /**
     * /delete-user --> Delete the user having the passed id.
     * 
     * @param id The id of the user to delete
     * @return A string describing if the user is succesfully deleted or not.
     */
    @RequestMapping("/delete-user")
    public String deleteUser(Long id) {
        try {
            userService.deleteById(id);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error deleting the user by id=" + id + ": " + ex.toString();
        }
        return "redirect:/users/all-users";
    }

    /**
     * /get-user-by-id --> Return information about user using his id.
     * 
     * @param id The id to search in the database.
     * @return A message with information about the user or a message error if
     *         the user is not found.
     */
    @RequestMapping("/get-user-by-id")
    @ResponseBody
    public String getUserById(long id) {
        User user = null;
        try {
            user = userService.findById(id);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "User not found";
        }
        return "id: " + user.getId() + ", last name: " + user.getLastName() + ", first name: " + user.getFirstName()
                + ", career level: " + user.getCareerLevel();
    }

    /**
     * /update-user --> Update the user in the database.
     * 
     * @return A string describing if the user is succesfully updated or not.
     */
    @RequestMapping(value = "/update-user", method = RequestMethod.GET)
    public String updateUser(Long id, String lastName, String firstName,
            String username, String password, String email, Long careerLevelId,
            Long groupId) {
        try {
            User user = userService.findById(id);
            user.setLastName(lastName);
            user.setFirstName(firstName);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            
            CareerLevel careerLevel = careerLevelService.findById(careerLevelId);
            user.setCareerLevel(careerLevel);
            
            Group group = groupService.findById(groupId);
            user.setGroup(group);
            
            userService.create(user);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error updating the user: " + ex.toString();
        }
        return "redirect:/users/all-users";
    }
} // class UserController
