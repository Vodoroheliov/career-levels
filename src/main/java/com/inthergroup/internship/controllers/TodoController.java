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
    
    @RequestMapping("/todos/all-tasks")
    public String allTasks(Model model) {
        model.addAttribute("todos", todoService.findAllCareerLevelTodos());
        model.addAttribute("careerLevels", careerLevelService.findAll());
        model.addAttribute("todoTypes", todoService.findAllTodoTypes());
        return "/todos/all-tasks";
    }
    
    @RequestMapping("/todos/todo-type")
    public String todo_type(Model model) {
        model.addAttribute("todoTypes", todoService.findAllTodoTypes());
        return "/todos/todo-type";
    }

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
    
    // You must delete todo type only after you deleted it from all
    // users that contained it.
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
    
//    /**
//     * Directs user to fill in the form for adding the finished task.
//     */
//    @RequestMapping(value = "/add-todo-to-user/{id}", method = RequestMethod.GET)
//    @Transactional
//    public String addTodoToUser(
//            @ModelAttribute("todoForm") AddFinishedTodoForm todoForm,
//            @PathVariable("id") Long id, final Model model) {
//        
//        if (model.asMap().containsKey("todoFormBindingResult"))
//        {
//            model.addAttribute("org.springframework.validation.BindingResult.todoForm",
//                    model.asMap().get("todoFormBindingResult"));
//        }
//        
////        if (!model.containsAttribute("todoForm")) {
////            model.addAttribute("todoForm", new AddFinishedTodoForm());
////        } else {
////            model.addAttribute("searchFormBacking", todoForm);
////        }
//        
//        model.addAttribute("userId", id);
//        model.addAttribute("todoTypes", todoService.findAllTodoTypes());
//        return "todos/add-finished-todo";
//    }

//    /**
//     * Adds the completed task to the user.
//     */
//    @RequestMapping(value = "/add-todo-to-user", method = RequestMethod.POST)
//    @Transactional
//    public String addTodoToUser(
//            @Valid @ModelAttribute("todoForm") final AddFinishedTodoForm todoForm,
//            final BindingResult bindingResult, Long userId,
//            final RedirectAttributes redirectAttributes) {
//        System.out.println(bindingResult.toString());
//        if (!bindingResult.hasErrors()) { // validation errors
//            if (todoForm.getDescription() == "") {
//                todoForm.setDescription(null);
//            }
//            try {
//                Calendar calendar = Calendar.getInstance();
//                java.sql.Timestamp dateOfCompletion =
//                        new java.sql.Timestamp(calendar.getTime().getTime());
//                todoService.addTodoToUser(userId, todoForm.getTodoId(),
//                        todoForm.getTodoTypeId(), dateOfCompletion,
//                        todoForm.getDescription());
//            } catch (Exception ex) {
//                return "redirect:/general-error?msg=" +
//                        "Error adding todo to user: " + ex.toString();
//            }
//        }
//        else {
//            //flash errors bound to "searchFormBacking"
//            redirectAttributes.addFlashAttribute(
//                    "todoFormBindingResult", bindingResult);
//            redirectAttributes.addFlashAttribute("todoForm", todoForm);
//            return "redirect:/add-todo-to-user/" + userId;
////            return "todos/add-finished-todo";
//        }
//        return "redirect:/users/progress-page/" + userId;
//    }

    /**
     * Adds the completed task to the user.
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
//            Calendar calendar = Calendar.getInstance();
//            java.sql.Timestamp dateOfCompletion =
//                    new java.sql.Timestamp(calendar.getTime().getTime());
            todoService.addTodoToUser(id, todoId, todoTypeId, dateOfCompletion,
                    description);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error adding todo to user: " + ex.toString();
        }
        return "redirect:/users/progress-page/" + id;
    }
    
//    /**
//     * Shows the form for updating the finished task.
//     */
//    @RequestMapping(value = "/update-todo-for-user/{id}", method = RequestMethod.GET)
//    @Transactional
//    public String updateTodoForUser(@PathVariable("id") Long id, Long careerLevelId,
//            String todoId, Model model) {
//        model.addAttribute("userId", id);
//        
//        // Fill form with data of existing todo
//        Todo todo = todoService.findTodo(id, careerLevelId, todoId);
//        AddFinishedTodoForm todoForm = new AddFinishedTodoForm();
//        todoForm.setTodoId(todo.getTodoId());
//        todoForm.setTodoTypeId(todo.getTodoTypeId());
//        todoForm.setDescription(todo.getDescription());
//        model.addAttribute("todoForm", todoForm);
//        
//        model.addAttribute("todoTypes", todoService.findAllTodoTypes());
//        System.out.println("todo: " + todo);
//        
//        return "/todos/update-finished-todo";
//    }
    
//    /**
//     * Update the existing finished task.
//     */
//    @RequestMapping(value = "/update-todo-for-user", method = RequestMethod.POST)
//    @Transactional
//    public String updateTodoForUser(
//            @Valid @ModelAttribute("todoForm") AddFinishedTodoForm todoForm,
//            BindingResult bindingResult, Long userId) {
//        System.out.println(bindingResult.toString());
//        if (!bindingResult.hasErrors()) { // validation errors
//            if (todoForm.getDescription() == "") {
//                todoForm.setDescription(null);
//            }
//            try {
//                User user = userService.findById(userId);
//                Todo todo = todoService.findTodo(userId,
//                        user.getCareerLevel().getId(), todoForm.getTodoId());
//                todo.setDescription(todoForm.getDescription());
//                todo.setTodoTypeId(todoForm.getTodoTypeId());
//                todoService.saveTodo(todo);
//            } catch (Exception ex) {
//                System.out.println("Test1: " + ex.toString());
//                return "redirect:/general-error?msg=" +
//                        "Error updating todo for user: " + ex.toString();
//            }
//        }
//        else {
//            return "redirect:/add-todo-to-user/" + userId;
//        }
//        return "redirect:/users/progress-page/" + userId;
//    }
    
    /**
     * Update the existing finished task.
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
