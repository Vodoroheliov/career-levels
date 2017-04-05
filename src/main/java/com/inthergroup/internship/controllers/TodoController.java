package com.inthergroup.internship.controllers;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inthergroup.internship.models.TodoType;
import com.inthergroup.internship.services.TodoService;

@Controller
public class TodoController {
    
    @Autowired
    private TodoService todoService;

    @RequestMapping("/create-todo-type")
    @ResponseBody
    public String createTodoType(String todoName) {
        TodoType todoType = null;
        try {
            todoType = new TodoType(todoName);
            todoService.create(todoType);
        } catch (Exception ex) {
            return "Error creating the Todo Type: " + ex.toString();
        }
        return "Todo Type succesfully created! (id = " + todoType.getId() + ")";
    }
    
    // You must delete todo type only after you deleted it from all
    // users that contained it.
    @RequestMapping("/delete-todo-type")
    @ResponseBody
    public String deleteTodoType(long id) {
        try {
            todoService.deleteById(id);
        } catch (Exception ex) {
            return "Error deleting the Todo Type by id #" + id + ": " + ex.toString();
        }
        return "Todo Type succesfully deleted!";
    }

    @RequestMapping("/add-todo-to-user")
    @ResponseBody
    @Transactional
    public String addTodoToUser(long userId, String todoId, long todoTypeId,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                    Timestamp dateOfCompletion, String description) {
        if (description == "") {
            description = null;
        }
        try {
            todoService.addTodoToUser(userId, todoId, todoTypeId,
                    dateOfCompletion, description);
        } catch (Exception ex) {
            return "Error adding todo to user: " + ex.toString();
        }
        return "Succesfully added todo to user!";
    }
    
    @RequestMapping("/remove-todo-from-user")
    @ResponseBody
    @Transactional
    public String removeTodoFromUser(long userId, String todoId,
            long careerLevelId) {
        // TODO check long variables to null value (because of error while testing)
        try {
            todoService.removeTodoFromUser(userId, todoId, careerLevelId);
        } catch (Exception ex) {
            return "Error removing todo from user: " + ex.toString();
        }
        return "Succesfully removed todo from user!";
    }
    
    @RequestMapping("/add-todo-to-career-level")
    @ResponseBody
    @Transactional
    public String addTodoToCareerLevel(long careerLevelId, long todoTypeId,
            int quantity) {
        try {
            todoService.addTodoToCareerLevel(careerLevelId, todoTypeId, quantity);
        } catch (Exception ex) {
            return "Error adding todo to career level: " + ex.toString();
        }
        return "Succesfully added todo to career level!";
    }
    
    @RequestMapping("/remove-todo-from-career-level")
    @ResponseBody
    @Transactional
    public String removeTodoFromCareerLevel(long careerLevelId, long todoTypeId) {
        try {
            todoService.removeTodoFromCareerLevel(careerLevelId, todoTypeId);
        } catch (Exception ex) {
            return "Error removing todo from career level: " + ex.toString();
        }
        return "Succesfully removed todo from career level!";
    }
    
} // class GroupController
