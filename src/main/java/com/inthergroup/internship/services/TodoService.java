package com.inthergroup.internship.services;

import java.util.List;

import com.inthergroup.internship.models.TodoType;

public interface TodoService {
    List<TodoType> findAll();

    TodoType findById(Long id);

    TodoType create(TodoType todo);

    TodoType edit(TodoType todo);

    void deleteById(Long id);
    
    void addTodoToUser(Long userId, Long todoId);

    void removeTodoFromUser(Long userId, Long todoId);

    void addTodoToCareerLevel(Long careerLevelId, Long todoId);

    void removeTodoFromCareerLevel(Long careerLevelId, Long todoId);

    List<String> findTodosFromLevel(Long id);
}
