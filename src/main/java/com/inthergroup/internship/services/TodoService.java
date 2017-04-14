package com.inthergroup.internship.services;


import java.util.Date;
import java.util.List;

import com.inthergroup.internship.models.Todo;
import com.inthergroup.internship.models.TodoType;

public interface TodoService {

    /**
     *  Find todo type
     */
    TodoType findTodoTypeById(Long id);
    
    List<TodoType> findAllTodoTypes();

    TodoType createTodoType(TodoType todo);

    TodoType saveTodoType(TodoType todo);

    void deleteTodoTypeById(Long id);
    
    Todo findTodo(Long userId, Long CareerLevelId, String todoId);
    
    /**
     *  Save completed todo
     */
    Todo saveTodo(Todo todo);
    
    void addTodoToUser(Long userId, String todoId, Long todoTypeId,
            Date dateOfCompletion, String description);

    void removeTodoFromUser(Long userId, String todoId, Long careerLevelId);

    void addTodoToCareerLevel(Long careerLevelId, Long todoTypeId, Integer quantity);

    void removeTodoFromCareerLevel(Long careerLevelId, Long todoTypeId);

    List<String> findTodosFromLevel(Long id);
    
    List<Object[]>findCurrentFinishedTodosByUserId(Long id);
    
    /**
     * Finds todos (for current career level) that user not finished yet.
     */
    List<Object[]>findCurrentTodosByUserId(Long id);
    
    List<Object[]>findAllFinishedTodosByUserId(Long id);
}
