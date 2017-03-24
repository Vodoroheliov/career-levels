package com.inthergroup.internship.controllers;

import com.inthergroup.internship.models.GroupUser;
import com.inthergroup.internship.services.GroupUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A class to test interactions with the MySQL database using the UserDao class.
 *
 * @author interns
 */
@Deprecated
@Controller
public class GroupUserController {

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------
    
    @Autowired
    private GroupUserService groupUserService;
//    private GroupUserDao groupsUsersDao;

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * /create-groups-users  --> Create a new GroupsUsers and save it in the database.
   * 
   * @param groupId Group's id
   * @param userId User's id
   * @return A string describing if the GroupsUsers is succesfully created or not.
   */
  @RequestMapping("/create-groups-users")
  @ResponseBody
  public String create(long groupId, long userId) {
    GroupUser groupsUsers = null;
    try {
      groupsUsers = new GroupUser(groupId, userId);
      groupUserService.create(groupsUsers);
    }
    catch (Exception ex) {
      return "Error creating the GroupsUsers: " + ex.toString();
    }
    return "GroupsUsers succesfully created! (id = " + groupsUsers.getId() + ")";
  }
  
  /**
   * /delete-groups-users  --> Delete the GroupsUsers having the passed id.
   * 
   * @param id The id of the GroupsUsers to delete
   * @return A string describing if the GroupsUsers is succesfully deleted or not.
   */
  @RequestMapping("/delete-groups-users")
  @ResponseBody
  public String delete(long id) {
    try {
      groupUserService.deleteById(id);
    }
    catch (Exception ex) {
      return "Error deleting the GroupsUsers: " + ex.toString();
    }
    return "GroupsUsers succesfully deleted!";
  }
  
  /**
   * /update-groups-users  --> Update the GroupsUsers in the database 
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
      GroupUser groupsUsers = groupUserService.findById(id);
      groupsUsers.setGroupId(groupId);
      groupsUsers.setUserId(userId);
      groupUserService.create(groupsUsers);
    }
    catch (Exception ex) {
      return "Error updating the GroupsUsers: " + ex.toString();
    }
    return "GroupsUsers succesfully updated!";
  }  
} // class GroupUserController
