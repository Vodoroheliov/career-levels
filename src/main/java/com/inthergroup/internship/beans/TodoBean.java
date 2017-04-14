package com.inthergroup.internship.beans;

import org.springframework.beans.factory.annotation.Autowired;

import com.inthergroup.internship.models.Todo;
import com.inthergroup.internship.services.TodoService;

public class TodoBean {
    
    @Autowired
    TodoService todoService;
    
    public Todo getTodo(Long userId, Long careerLevelId, String todoId) {
     // Fill form with data of existing todo
      Todo todo = todoService.findTodo(userId, careerLevelId, todoId);
      return todo;
    }
}
