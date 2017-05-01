package com.inthergroup.internship.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inthergroup.internship.forms.SignupForm;
import com.inthergroup.internship.models.CareerLevel;
import com.inthergroup.internship.models.Group;
import com.inthergroup.internship.models.User;
import com.inthergroup.internship.services.CareerLevelService;
import com.inthergroup.internship.services.GroupService;
import com.inthergroup.internship.services.TodoService;
import com.inthergroup.internship.services.UserService;


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
    
    @RequestMapping("/login")
    public String login() {
        return "/users/login";
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "users/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupUser(
            @Valid @ModelAttribute("signupForm") SignupForm signupForm,
            BindingResult bindingResult) {
        System.out.println(bindingResult.toString());
        if (!bindingResult.hasErrors()) { // validation errors
            if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) { // check password match
                String pwd = signupForm.getPassword();
                BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
                String hashPwd = bc.encode(pwd);

                User newUser = new User();
                newUser.setFirstName(signupForm.getFirstName());
                newUser.setLastName(signupForm.getLastName());
                newUser.setEmail(signupForm.getEmail());
                newUser.setUsername(signupForm.getUsername());
                newUser.setPasswordHash(hashPwd);
                
                CareerLevel careerLevel = careerLevelService.findById((long) 1); // id=1 for career level "Internship"
                newUser.setCareerLevel(careerLevel);
                
                Group group = groupService.findByRole("USER");
                newUser.setGroup(group);
                
                if (userService.findByUsername(signupForm.getUsername()) == null) {
                    userService.create(newUser);
                } else {
                    bindingResult.rejectValue("username", "error.userexists", "Username already exists");
                    return "/users/signup";
                }
            } else {
                bindingResult.rejectValue("passwordCheck", "error.pwdmatch", "Passwords does not match");
                return "/users/signup";
            }
        } else {
            return "/users/signup";
        }
        return "redirect:/login";
    }

    /**
     * Prepares data for page with all users list.
     * 
     * @param model
     * @return
     */
    @RequestMapping("/users/all-users")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("careerLevels", careerLevelService.findAll());
        model.addAttribute("groups", groupService.findAll());
        return "/users/all-users";
    }

    /**
     * Prepares data for page with current progress for specific user.
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/users/progress-page/{id}")
    public String progressPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("userId", id);
        model.addAttribute("username", userService.findById(id).getUsername());
        model.addAttribute("todos", todoService.findCurrentTodosByUserId(id));
        model.addAttribute(
                "finishedTodos", todoService.findCurrentFinishedTodosByUserId(id));
        model.addAttribute("user", userService.findById(id));
        model.addAttribute(
                "careerLevel", careerLevelService.findCareerLevelByUserId(id));
        model.addAttribute("todoTypes", todoService.findAllTodoTypes());
        return "users/progress-page";
    }

    /**
     * Prepares data for page with total progress for specific user.
     * 
     * @param id
     * @param model
     * @return
     */
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
     * Increases level of user.
     * 
     * @param userId Id of user.
     * @return
     */
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
     */
    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public String createUser(
            String lastName, String firstName, String username, String password,
            String email, Long careerLevelId, Long groupId) {
        
        User user = null;
        try {
            CareerLevel careerLevel = careerLevelService.findById(careerLevelId);
            Group group = groupService.findById(groupId);
            
            BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
            String hashPwd = bc.encode(password);
            
            user = new User(lastName, firstName, username, hashPwd, email,
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
     *  /update-user --> Update the user in the database.
     *  
     * @param id User id.
     * @param lastName New last name.
     * @param firstName New first name.
     * @param username New username.
     * @param password New password.
     * @param email New email address.
     * @param careerLevelId New career level id.
     * @param groupId New group id.
     * @return
     */
    @RequestMapping(value = "/update-user", method = RequestMethod.GET)
    public String updateUser(Long id, String lastName, String firstName,
            String username, String email, Long careerLevelId,
            Long groupId) {
        try {
            User user = userService.findById(id);
            user.setLastName(lastName);
            user.setFirstName(firstName);
            user.setUsername(username);
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
    
    /**
     * /delete-user --> Delete the user having the passed id.
     * 
     * @param id The id of the user to delete
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

} // class UserController
