package com.inthergroup.internship.controllers;

import com.inthergroup.internship.models.GroupsUsers;
import com.inthergroup.internship.models.GroupsUsersDao;

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
public class GroupsUsersController {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * /create  --> Create a new GroupsUsers and save it in the database.
   * 
   * @param groupId Group's id
   * @param userId User's id
   * @return A string describing if the GroupsUsers is succesfully created or not.
   */
  @RequestMapping("/create-groups-users")
  @ResponseBody
  public String create(long groupId, long userId) {
    GroupsUsers groupsUsers = null;
    try {
      groupsUsers = new GroupsUsers(groupId, userId);
      groupsUsersDao.save(groupsUsers);
    }
    catch (Exception ex) {
      return "Error creating the GroupsUsers: " + ex.toString();
    }
    return "GroupsUsers succesfully created! (id = " + groupsUsers.getId() + ")";
  }
  
  /**
   * /delete  --> Delete the GroupsUsers having the passed id.
   * 
   * @param id The id of the GroupsUsers to delete
   * @return A string describing if the GroupsUsers is succesfully deleted or not.
   */
  @RequestMapping("/delete-groups-users")
  @ResponseBody
  public String delete(long id) {
    try {
      GroupsUsers groupsUsers = new GroupsUsers(id);
      groupsUsersDao.delete(groupsUsers);
    }
    catch (Exception ex) {
      return "Error deleting the GroupsUsers: " + ex.toString();
    }
    return "GroupsUsers succesfully deleted!";
  }
  
  /**
   * /update  --> Update the GroupsUsers in the database 
   * having the passed id.
   * 
   * @param id The id for the GroupsUsers to update.
   * @param groupId Group's id
   * @param userId User's id
   * @return A string describing if the GroupsUsers is succesfully updated or not.
   */
  @RequestMapping("/update-groups-users")
  @ResponseBody
  public String updateGroupsUsers(long id, long groupId, long userId) {
    try {
      GroupsUsers groupsUsers = groupsUsersDao.findOne(id);
      groupsUsers.setGroupId(groupId);
      groupsUsers.setUserId(userId);
      groupsUsersDao.save(groupsUsers);
    }
    catch (Exception ex) {
      return "Error updating the GroupsUsers: " + ex.toString();
    }
    return "GroupsUsers succesfully updated!";
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  @Autowired
  private GroupsUsersDao groupsUsersDao;
  
} // class UserController
