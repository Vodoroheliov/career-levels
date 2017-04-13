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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inthergroup.internship.forms.AddFinishedTodoForm;
import com.inthergroup.internship.models.Todo;
import com.inthergroup.internship.models.TodoType;
import com.inthergroup.internship.models.User;
import com.inthergroup.internship.services.TodoService;
import com.inthergroup.internship.services.UserService;

@Controller
public class TodoController {
    
    @Autowired
    private TodoService todoService;
    
    @Autowired
    private UserService userService;

    @RequestMapping("/create-todo-type")
    @ResponseBody
    public String createTodoType(String todoName) {
        TodoType todoType = null;
        try {
            todoType = new TodoType(todoName);
            todoService.createTodoType(todoType);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                "Error creating the Todo Type: " + ex.toString();
        }
        return "Todo Type succesfully created! (id = " + todoType.getId() + ")";
    }
    
    // You must delete todo type only after you deleted it from all
    // users that contained it.
    @RequestMapping("/delete-todo-type")
    @ResponseBody
    public String deleteTodoType(long id) {
        try {
            todoService.deleteTodoTypeById(id);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error deleting the Todo Type by id #" + id + ": " + ex.toString();
        }
        return "Todo Type succesfully deleted!";
    }
    
    /**
     * Directs user to fill in the form for adding the finished task.
     */
    @RequestMapping(value = "/add-todo-to-user/{id}", method = RequestMethod.GET)
    @Transactional
    public String addTodoToUser(
            @ModelAttribute("todoForm") AddFinishedTodoForm todoForm,
            @PathVariable("id") Long id, final Model model) {
        
        if (model.asMap().containsKey("todoFormBindingResult"))
        {
            model.addAttribute("org.springframework.validation.BindingResult.todoForm",
                    model.asMap().get("todoFormBindingResult"));
        }
        
//        if (!model.containsAttribute("todoForm")) {
//            model.addAttribute("todoForm", new AddFinishedTodoForm());
//        } else {
//            model.addAttribute("searchFormBacking", todoForm);
//        }
        
        model.addAttribute("userId", id);
        model.addAttribute("todoTypes", todoService.findAllTodoTypes());
        return "todos/add-finished-todo";
    }

    /**
     * Adds the completed task to the user.
     */
    @RequestMapping(value = "/add-todo-to-user", method = RequestMethod.POST)
    @Transactional
    public String addTodoToUser(
            @Valid @ModelAttribute("todoForm") final AddFinishedTodoForm todoForm,
            final BindingResult bindingResult, Long userId,
            final RedirectAttributes redirectAttributes) {
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
                return "redirect:/general-error?msg=" +
                        "Error adding todo to user: " + ex.toString();
            }
        }
        else {
            //flash errors bound to "searchFormBacking"
            redirectAttributes.addFlashAttribute(
                    "todoFormBindingResult", bindingResult);
            redirectAttributes.addFlashAttribute("todoForm", todoForm);
            return "redirect:/add-todo-to-user/" + userId;
//            return "todos/add-finished-todo";
        }
        return "redirect:users/progress-page/" + userId;
    }
    
    /**
     * Shows the form for updating the finished task.
     */
    @RequestMapping(value = "/update-todo-for-user/{id}", method = RequestMethod.GET)
    @Transactional
    public String updateTodoForUser(@PathVariable("id") Long id, Long careerLevelId,
            String todoId, Model model) {
        model.addAttribute("userId", id);
        
        // Fill form with data of existing todo
        Todo todo = todoService.findTodo(id, careerLevelId, todoId);
        AddFinishedTodoForm todoForm = new AddFinishedTodoForm();
        todoForm.setTodoId(todo.getTodoId());
        todoForm.setTodoTypeId(todo.getTodoTypeId());
        todoForm.setDescription(todo.getDescription());
        model.addAttribute("todoForm", todoForm);
        
        model.addAttribute("todoTypes", todoService.findAllTodoTypes());
        System.out.println("todo: " + todo);
        
        return "todos/update-finished-todo";
    }
    
    /**
     * Update the existing finished task.
     */
    @RequestMapping(value = "/update-todo-for-user", method = RequestMethod.POST)
    @Transactional
    public String updateTodoForUser(
            @Valid @ModelAttribute("todoForm") AddFinishedTodoForm todoForm,
            BindingResult bindingResult, Long userId) {
        System.out.println(bindingResult.toString());
        if (!bindingResult.hasErrors()) { // validation errors
            if (todoForm.getDescription() == "") {
                todoForm.setDescription(null);
            }
            try {
                User user = userService.findById(userId);
                Todo todo = todoService.findTodo(userId,
                        user.getCareerLevel().getId(), todoForm.getTodoId());
                todo.setDescription(todoForm.getDescription());
                todo.setTodoTypeId(todoForm.getTodoTypeId());
                todoService.saveTodo(todo);
            } catch (Exception ex) {
                System.out.println("Test1: " + ex.toString());
                return "redirect:/general-error?msg=" +
                        "Error updating todo for user: " + ex.toString();
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
            return "redirect:/general-error?msg=" +
                    "Error removing todo from user: " + ex.toString();
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
            return "redirect:/general-error?msg=" +
                    "Error adding todo to career level: " + ex.toString();
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
            return "redirect:/general-error?msg=" +
                    "Error removing todo from career level: " + ex.toString();
        }
        return "Succesfully removed todo from career level!";
    }
    
} // class GroupController
