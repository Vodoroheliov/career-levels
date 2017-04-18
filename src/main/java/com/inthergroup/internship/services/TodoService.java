package com.inthergroup.internship.services;


import java.util.Date;
import java.util.List;

import com.inthergroup.internship.models.CareerLevelTodo;
import com.inthergroup.internship.models.Todo;
import com.inthergroup.internship.models.TodoType;

public interface TodoService {

    /**
     *  Returns instance of TodoType entity by his id.
     */
    TodoType findTodoTypeById(Long id);
    
    /**
     * Returns a list of all instances of TodoType entity.
     * @return
     */
    List<TodoType> findAllTodoTypes();

    /**
     * Saves instance of TodoType entity.
     */
    TodoType createTodoType(TodoType todo);

    /**
     * Saves instance of TodoType entity.
     */
    TodoType saveTodoType(TodoType todo);

    /**
     * Deletes instance of TodoType entity by his id.
     * @param id
     */
    void deleteTodoTypeById(Long id);
    
    /**
     * Returns instance of Todo entity.
     * @param userId User id.
     * @param CareerLevelId Career level id.
     * @param todoId Title of finished todo.
     * @return Finished todo.
     */
    Todo findTodo(Long userId, Long CareerLevelId, String todoId);
    
    /**
     *  Save completed todo
     */
    Todo saveTodo(Todo todo);
    
    /**
     * Adds finished todo for specifc user.
     * @param userId User id.
     * @param todoId Title of todo.
     * @param todoTypeId Todo type id.
     * @param dateOfCompletion Date of completion.
     * @param description Description of completed task.
     */
    void addTodoToUser(Long userId, String todoId, Long todoTypeId,
            Date dateOfCompletion, String description);

    /**
     * Removes finished todo from a specifc user.
     * @param userId Uesr id.
     * @param todoId title of completed task.
     * @param careerLevelId Career level id.
     */
    void removeTodoFromUser(Long userId, String todoId, Long careerLevelId);

    /**
     * Adds todo to a specific career level.
     * @param careerLevelId Career level id.
     * @param todoTypeId Todo type id.
     * @param quantity The number of these todo types.
     */
    void addTodoToCareerLevel(Long careerLevelId, Long todoTypeId, Integer quantity);

    /**
     * Removes todo from a specific career level.
     * @param careerLevelId Career level id.
     * @param todoTypeId Todo type id.
     */
    void removeTodoFromCareerLevel(Long careerLevelId, Long todoTypeId);

    /**
     * Returns a list with the names of all todos from a specific career level.
     * @param id
     * @return
     */
    List<String> findTodosFromLevel(Long id);
    
    /**
     * Returns a list of all finished todos for a specific user that correspond
     * to current user's career level.
     * @param id User id.
     */
    List<Object[]>findCurrentFinishedTodosByUserId(Long id);
    
    /**
     * Returns a list of current unfinished tasks (for current user's career level)
     * 
     * @param id User id.
     */
    List<Object[]>findCurrentTodosByUserId(Long id);
    
    /**
     * Returns a list of total progress (with all finished tasks for each career level)
     * of user.
     * @param id User id.
     */
    List<Object[]>findAllFinishedTodosByUserId(Long id);
    
    /**
     * Returns all instances of CareerLevelTodo entity.
     */
    List<CareerLevelTodo> findAllCareerLevelTodos();
    
    /**
     * Returns a specific instance of CareerLevelTodo entity.
     * 
     * @param careerLevelId career level id.
     * @param todoTypeId todo type id.
     */
    CareerLevelTodo findCareerLevelTodo(Long careerLevelId, Long todoTypeId);
    
    /**
     * Deletes instance of CareerLevelTodo entity.
     */
    void deleteCareerLevelTodo(CareerLevelTodo careerLevelTodo);
}
