package com.inthergroup.internship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inthergroup.internship.models.Group;
import com.inthergroup.internship.services.GroupService;

@Controller
public class GroupController {
    
    @Autowired
    private GroupService groupService;

    @RequestMapping("/create-group")
    @ResponseBody
    public String createGroup(String groupName) {
        Group group = null;
        try {
            group = new Group(groupName);
            groupService.create(group);
        } catch (Exception ex) {
            return "Error creating the Group: " + ex.toString();
        }
        return "Group succesfully created! (id = " + group.getId() + ")";
    }

    @RequestMapping("/add-group-to-user")
    @ResponseBody
    @Transactional
    public String addGroupToUser(long userId, long groupId) {
        try {
            groupService.addGroupToUser(userId, groupId);
        } catch (Exception ex) {
            return "Error adding todo to user: " + ex.toString();
        }
        return "Succesfully added todo to user!";
    }
} // class GroupController
