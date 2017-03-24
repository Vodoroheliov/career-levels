package com.inthergroup.internship.services;

import java.util.List;

import com.inthergroup.internship.models.Todo;

public interface TodoService {
    List<Todo> findAll();

    Todo findById(Long id);

    Todo create(Todo todo);

    Todo edit(Todo todo);

    void deleteById(Long id);
    
    void addTodoToUser(Long userId, Long todoId);

    void removeTodoFromUser(Long userId, Long todoId);
}
