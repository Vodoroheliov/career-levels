package com.inthergroup.internship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inthergroup.internship.models.Group;
import com.inthergroup.internship.services.GroupService;

@Controller
public class GroupController {
    
    @Autowired
    private GroupService groupService;

    /**
     * Creates new group (for access control).
     * @param groupName Name of group.
     * @return
     */
    @RequestMapping("/create-group")
    @ResponseBody
    public String createGroup(String groupName) {
        Group group = null;
        try {
            group = new Group(groupName);
            groupService.create(group);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error creating the Group: " + ex.toString();
        }
        return "Group succesfully created! (id = " + group.getId() + ")";
    }

//    /**
//     * Adds additional group to user.
//     * @param userId
//     * @param groupId
//     * @return
//     */
//    @RequestMapping("/add-group-to-user")
//    @ResponseBody
//    @Transactional
//    public String addGroupToUser(long userId, long groupId) {
//        try {
//            groupService.addGroupToUser(userId, groupId);
//        } catch (Exception ex) {
//            return "Error adding todo to user: " + ex.toString();
//        }
//        return "Succesfully added todo to user!";
//    }
    
    /**
     * Updates group for user.
     * 
     * @param userId Id of user.
     * @param groupId Id of group to replace with.
     * @return
     */
    @RequestMapping("/update-user-group")
    @ResponseBody
    public String updateUserGroup(long userId, long groupId) {
        try {
            groupService.updateUserGroup(userId, groupId);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error updating user's group: " + ex.toString();
        }
        return "Succesfully updated user's group!";
    }
    
    /**
     * Deletes group.
     * You must delete group only after you deleted it from all
     * users that contained it.
     * 
     * @param id Id of group to delete.
     * @return
     */
    @RequestMapping("/delete-group")
    @ResponseBody
    public String deleteGroup(long id) {
        try {
            groupService.deleteById(id);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error deleting the group by id #" + id + ": " + ex.toString();
        }
        return "Group succesfully deleted!";
    }
    
//    /**
//     * Removes group from user.
//     */
//    @RequestMapping("/remove-group-from-user")
//    @ResponseBody
//    @Transactional
//    public String removeGroupFromUser(long userId, long groupId) {
//        try {
//            groupService.removeGroupFromUser(userId, groupId);
//        } catch (Exception ex) {
//            return "Error removing group from user: " + ex.toString();
//        }
//        return "Succesfully removed group from user!";
//    }
    
} // class GroupController
