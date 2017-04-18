package com.inthergroup.internship.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inthergroup.internship.models.CareerLevelTodo;
import com.inthergroup.internship.models.Todo;
import com.inthergroup.internship.models.TodoType;
import com.inthergroup.internship.models.User;
import com.inthergroup.internship.services.CareerLevelService;
import com.inthergroup.internship.services.TodoService;
import com.inthergroup.internship.services.UserService;

@Controller
public class TodoController {
    
    @Autowired
    private TodoService todoService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CareerLevelService careerLevelService;
    
    /**
     * Prepares data for page with all tasks list.
     */
    @RequestMapping("/todos/all-tasks")
    public String allTasks(Model model) {
        model.addAttribute("todos", todoService.findAllCareerLevelTodos());
        model.addAttribute("careerLevels", careerLevelService.findAll());
        model.addAttribute("todoTypes", todoService.findAllTodoTypes());
        return "/todos/all-tasks";
    }
    
    /**
     * Prepares data for page with all todo types list.
     */
    @RequestMapping("/todos/todo-type")
    public String todo_type(Model model) {
        model.addAttribute("todoTypes", todoService.findAllTodoTypes());
        return "/todos/todo-type";
    }

    /**
     * Creates new todo type.
     * 
     * @param todoName Name of new todo type.
     * @return
     */
    @RequestMapping("/create-todo-type")
    public String createTodoType(String todoName) {
        TodoType todoType = null;
        try {
            todoType = new TodoType(todoName);
            todoService.createTodoType(todoType);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                "Error creating the Todo Type: " + ex.toString();
        }
        return "redirect:/todos/todo-type";
    }
    
    /**
     * Updates existing todo type.
     * 
     * @param todoTypeId Id of todo type to update.
     * @param newTodoName New name of todo type.
     * @return
     */
    @RequestMapping("/update-todo-type")
    public String updateTodoType(Long todoTypeId, String newTodoName) {
        TodoType todoType = null;
        try {
            todoType = todoService.findTodoTypeById(todoTypeId);
            todoType.setName(newTodoName);
            todoService.saveTodoType(todoType);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                "Error creating the Todo Type: " + ex.toString();
        }
        return "redirect:/todos/todo-type";
    }
    
    /**
     * Deletes todo type.
     * @param id Id of todo type.
     * @return
     */
    @RequestMapping("/delete-todo-type")
    public String deleteTodoType(long id) {
        try {
            todoService.deleteTodoTypeById(id);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error deleting the Todo Type by id #" + id + ": " + ex.toString();
        }
        return "redirect:/todos/todo-type";
    }

    /**
     * Adds the completed task to the user.
     * 
     * @param id Id of user.
     * @param todoId Id that represents title of completed task.
     * @param description Description of completed task.
     * @param todoTypeId Id of todo type.
     * @param dateOfCompletion Date of task completion.
     * @return
     */
    @RequestMapping(value = "/add-todo-to-user/{id}", method = RequestMethod.POST)
    @Transactional
    public String addTodoToUser(
            @PathVariable("id") Long id,
            @RequestParam("todoId") String todoId,
            @RequestParam("description") String description,
            @RequestParam("todoTypeId") Long todoTypeId,
            @RequestParam("dateOfCompletion") @DateTimeFormat(pattern="yyyy/mm/dd")
                    Date dateOfCompletion) {
        
        if (description == "") {
            description = null;
        }
        if (dateOfCompletion == null) {
            dateOfCompletion = new Date();
        }
        try {
            todoService.addTodoToUser(id, todoId, todoTypeId, dateOfCompletion,
                    description);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error adding todo to user: " + ex.toString();
        }
        return "redirect:/users/progress-page/" + id;
    }
    
    /**
     * Updates the existing finished task.
     * 
     * @param id Id of user.
     * @param todoId Id that represents title of completed task.
     * @param description New description of completed task.
     * @param todoTypeId New id of todo type.
     * @param dateOfCompletion New date of task completion.
     * @return
     */
    @RequestMapping(value = "/update-todo-for-user/{id}", method = RequestMethod.POST)
    @Transactional
    public String updateTodoForUser(
            @PathVariable("id") Long id,
            @RequestParam("todoId") String todoId,
            @RequestParam("description") String description,
            @RequestParam("todoTypeId") Long todoTypeId,
            @RequestParam("dateOfCompletion") @DateTimeFormat(pattern="yyyy/mm/dd")
                    Date dateOfCompletion) {
        
        if (description == "") {
            description = null;
        }
        if (dateOfCompletion == null) {
            dateOfCompletion = new Date();
        }
        try {
            User user = userService.findById(id);
            Todo todo = todoService.findTodo(id, user.getCareerLevel().getId(),
                    todoId);
            todo.setDescription(description);
            todo.setTodoTypeId(todoTypeId);
            todo.setDateOfCompletion(dateOfCompletion);
            todoService.saveTodo(todo);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error updating todo for user: " + ex.toString();
        }
        return "redirect:/users/progress-page/" + id;
    }
    
    /**
     * Removes finished todo from user.
     * 
     * @param userId Id of user.
     * @param todoId Id of todo to remove.
     * @param careerLevelId Career level of user.
     * @return
     */
    @RequestMapping(value = "/remove-todo-from-user", method = RequestMethod.GET)
    @Transactional
    public String removeTodoFromUser(Long userId, String todoId,
            Long careerLevelId) {
        try {
            todoService.removeTodoFromUser(userId, todoId, careerLevelId);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error removing todo from user: " + ex.toString();
        }
        return "redirect:/users/progress-page/" + userId;
    }
    
    /**
     * Adds new todo to career level.
     * @param careerLevelId Id of career level.
     * @param todoTypeId Id of todo type.
     * @param quantity The number of these benefits.
     * @return
     */
    @RequestMapping(value = "/add-todo-to-career-level", method = RequestMethod.POST)
    @Transactional
    public String addTodoToCareerLevel(long careerLevelId, long todoTypeId,
            int quantity) {
        try {
            todoService.addTodoToCareerLevel(careerLevelId, todoTypeId, quantity);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error adding todo to career level: " + ex.toString();
        }
        return "redirect:/todos/all-tasks";
    }
    
    /**
     * Updates benefit for a specific career level.
     * 
     * @param oldCareerLevelId Previous career level id.
     * @param oldTodoTypeId Previous todo type id.
     * @param newCareerLevelId Substitutional career level id.
     * @param newTodoTypeId Substitutional benefit type id.
     * @param quantity Substitutional number of benefits.
     * @return
     */
    @RequestMapping(value = "/update-todo-for-career-level", method = RequestMethod.GET)
    @Transactional
    public String updateTodoForCareerLevel(
            Long oldCareerLevelId, Long oldTodoTypeId,
            Long newCareerLevelId, Long newTodoTypeId,
            int quantity) {
        try {
            if (oldCareerLevelId == newCareerLevelId &&
                    oldTodoTypeId == newTodoTypeId) {
                CareerLevelTodo careerLevelTodo =
                        todoService.findCareerLevelTodo(oldCareerLevelId,
                                oldTodoTypeId);
                careerLevelTodo.setQuantity(quantity);
            }
            else {
                todoService.removeTodoFromCareerLevel(oldCareerLevelId, oldTodoTypeId);
                todoService.addTodoToCareerLevel(newCareerLevelId, newTodoTypeId,
                        quantity);
            }
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error adding todo to career level: " + ex.toString();
        }
        return "redirect:/todos/all-tasks";
    }
    
    /**
     * Removes benefit from a specific career level.
     * 
     * @param careerLevelId Id of career level.
     * @param todoTypeId Id of todo type.
     * @return
     */
    @RequestMapping("/remove-todo-from-career-level")
    @Transactional
    public String removeTodoFromCareerLevel(Long careerLevelId, Long todoTypeId) {
        try {
            todoService.removeTodoFromCareerLevel(careerLevelId, todoTypeId);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error removing todo from career level: " + ex.toString();
        }
        return "redirect:/todos/all-tasks";
    }
} // class TodoController
