package com.inthergroup.internship.controllers;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inthergroup.internship.forms.AddFinishedTodoForm;
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
    
    /**
     * Directs user to fill in the form for adding the finished task.
     */
    @RequestMapping(value = "/add-todo-to-user/{id}", method = RequestMethod.GET)
    @Transactional
    public String addTodoToUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("userId", id);
        model.addAttribute("todoForm", new AddFinishedTodoForm());
        model.addAttribute("todoTypes", todoService.findAll());
        return "todos/add-finished-todo";
    }

    /**
     * Adds the completed task to the user.
     */
    @RequestMapping(value = "/add-todo-to-user", method = RequestMethod.POST)
    @Transactional
    public String addTodoToUser(
            @Valid @ModelAttribute("todoForm") AddFinishedTodoForm todoForm,
            BindingResult bindingResult, Long userId) {
        System.out.println(bindingResult.toString());
        if (!bindingResult.hasErrors()) { // validation errors
            if (todoForm.getDescription() == "") {
                todoForm.setDescription(null);
            }
            try {
                Calendar calendar = Calendar.getInstance();
                java.sql.Timestamp dateOfCompletion =
                        new java.sql.Timestamp(calendar.getTime().getTime());
                todoService.addTodoToUser(userId, todoForm.getTodoId(),
                        todoForm.getTodoTypeId(), dateOfCompletion,
                        todoForm.getDescription());
            } catch (Exception ex) {
                return "Error adding todo to user: " + ex.toString();
            }
        }
        else {
            return "redirect:/add-todo-to-user/" + userId;
        }
        return "redirect:users/progress-page/" + userId;
    }
    
    @RequestMapping(value = "/remove-todo-from-user", method = RequestMethod.GET)
    @Transactional
    public String removeTodoFromUser(long userId, String todoId,
            long careerLevelId) {
        // TODO check long variables to null value (because of error while testing)
        try {
            todoService.removeTodoFromUser(userId, todoId, careerLevelId);
        } catch (Exception ex) {
            return "Error removing todo from user: " + ex.toString();
        }
        return "redirect:users/progress-page/" + userId;
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
