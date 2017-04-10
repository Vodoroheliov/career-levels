package com.inthergroup.internship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    @RequestMapping("/users/progress-page/{id}")
    public String progressPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("userId", id);
        model.addAttribute("todos", todoService.findCurrentTodosByUserId(id));
        model.addAttribute(
                "finishedTodos", todoService.findCurrentFinishedTodosByUserId(id));
        model.addAttribute("user", userService.findById(id));
        model.addAttribute(
                "careerLevel", careerLevelService.findCareerLevelByUserId(id));
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

    /**
     * /create  --> Create a new user and save it in the database.
     * 
     * @return A string describing if the user is succesfully created or not.
     */
    @RequestMapping("/create-user")
    @ResponseBody
    public String createUser(String lastName, String firstName, String login,
            String password, String email, Long careerLevelId, Long groupId) {
        User user = null;
        CareerLevel careerLevel = careerLevelService.findById(careerLevelId);
        Group group = groupService.findById(groupId);
        try {
            user = new User(lastName, firstName, login, password, email,
                    careerLevel, group);
            userService.create(user);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getId() + ")";
    }

    /**
     * /delete-user --> Delete the user having the passed id.
     * 
     * @param id The id of the user to delete
     * @return A string describing if the user is succesfully deleted or not.
     */
    @RequestMapping("/delete-user")
    @ResponseBody
    public String deleteUser(long id) {
        try {
            userService.deleteById(id);
        } catch (Exception ex) {
            return "Error deleting the user by id #" + id + ": " + ex.toString();
        }
        return "User succesfully deleted!";
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
            return "User not found";
        }
        return "id: " + user.getId() + ", last name: " + user.getLastName() + ", first name: " + user.getFirstName()
                + ", career level: " + user.getCareerLevel();
    }

    /**
     * /update-user --> Update the user in the database.
     * 
     * @return A string describing if the user is succesfully updated or not.
     */
    @RequestMapping("/update-user")
    @ResponseBody
    public String updateUser(long id, String lastName, String firstName, String username,
            String password, String email, String levelName) {
        try {
            // CareerLevel careerLevel = new CareerLevel(levelName);
            // careerLevelService.create(careerLevel);
            User user = userService.findById(id);
            user.setLastName(lastName);
            user.setFirstName(firstName);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            // TODO Change this operation to appropriate (to comply associations)
            user.getCareerLevel().setName(levelName);
            userService.create(user);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

} // class UserController
