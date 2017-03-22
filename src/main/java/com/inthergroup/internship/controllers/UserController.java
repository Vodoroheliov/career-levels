package com.inthergroup.internship.controllers;

import com.inthergroup.internship.models.User;
import com.inthergroup.internship.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A class to test interactions with the MySQL database using the UserDao class.
 *
 * @author interns
 */
@Controller
public class UserController {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * /create  --> Create a new user and save it in the database.
   * 
   * @param email User's email
   * @param name User's name
   * @return A string describing if the user is succesfully created or not.
   */
  @RequestMapping("/create")
  @ResponseBody
  public String create(String lastName, String firstName, String login,
                       String password, String email, String careerLevel) {
    User user = null;
    try {
      user = new User(lastName, firstName, login,
                      password, email, careerLevel);
      userDao.save(user);
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created! (id = " + user.getId() + ")";
  }
  
  /**
   * /delete  --> Delete the user having the passed id.
   * 
   * @param id The id of the user to delete
   * @return A string describing if the user is succesfully deleted or not.
   */
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      userDao.delete(user);
    }
    catch (Exception ex) {
      return "Error deleting the user: " + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  /**
   * /get-by-email  --> Return the id for the user having the passed email.
   * 
   * @param email The email to search in the database.
   * @return The user id or a message error if the user is not found.
   */
  @RequestMapping("/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = userDao.findByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }
  
  /**
   * /get-by-id  --> Return information about user using his id.
   * 
   * @param id The id to search in the database.
   * @return A message with information about the user or a message error
   * if the user is not found.
   */
  @RequestMapping("/get-by-id")
  @ResponseBody
  public String getById(long id) {
      User user = null;
      try {
          user = userDao.findById(id);
      }
      catch (Exception ex) {
          return "User not found";
      }
      return "id: " + user.getId() + ", last name: " + user.getLastName() +
             ", first name: " + user.getFirstName() +
             ", career level: " + user.getCareerLevel();
  }
  
  /**
   * /update  --> Update the email and the name for the user in the database 
   * having the passed id.
   * 
   * @param id The id for the user to update.
   * @param email The new email.
   * @param name The new name.
   * @return A string describing if the user is succesfully updated or not.
   */
  @RequestMapping("/update")
  @ResponseBody
  public String updateUser(long id, String lastName, String firstName, String login,
                           String password, String email, String careerLevel) {
    try {
      User user = userDao.findOne(id);
      user.setLastName(lastName);
      user.setFirstName(firstName);
      user.setLogin(login);
      user.setPassword(password);
      user.setEmail(email);
      user.setCareerLevel(careerLevel);
      userDao.save(user);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private UserDao userDao;
  
} // class UserController
