package com.inthergroup.internship.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inthergroup.internship.models.CareerLevelTodo;
import com.inthergroup.internship.models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    /**
     * Returns a specific instance of Todo entity.
     * @param userId Id of user.
     * @param careerLevelId Id of career level.
     * @param todoId Represent the title of todo.
     */
    @Query ("select t from Todo t where t.primaryKey.user.id = :userId " +
            "and t.primaryKey.careerLevel.id = :careerLevelId " +
            "and t.primaryKey.todoId = :todoId")
    Todo findTodo(@Param("userId")Long userId,
            @Param("careerLevelId")Long careerLevelId, @Param("todoId")String todoId);
    
    /**
     * Returns a list of all Todo names that correspond to a specific career level.
     * 
     * @param id
     */
    @Query("select name from TodoType where id in " +
            "(select ct.primaryKey.todoType.id from CareerLevelTodo ct " +
            "where ct.primaryKey.careerLevel.id = ?1)")
    public List<String> findTodosFromLevel(Long id);
    
    /**
     * Returns a list of all finished todos for a specific user that correspond
     * to current user's career level.
     * 
     * @param id Id of user.
     */
    @Query("select tt, t from TodoType tt, Todo t, User u " +
            "where tt.id = t.todoTypeId and t.primaryKey.user.id = u.id " +
            "and t.primaryKey.user.id = :userId " +
            "and t.primaryKey.careerLevel.id = u.careerLevel.id")
    public List<Object[]> findCurrentFinishedTodosByUserId(@Param("userId")Long id);
    
    /**
     * Returns a list of current unfinished tasks (for current user's career level)
     * 
     * @param id Id of user.
     */
    @Query("select tt, ct from TodoType tt, CareerLevelTodo ct, User u " +
            "where tt.id = ct.primaryKey.todoType.id " +
            "and ct.primaryKey.careerLevel.id = u.careerLevel.id " +
            "and u.id = :userId and ct.primaryKey.todoType.id not in " +
            "(select t.todoTypeId from Todo t where t.primaryKey.user.id = :userId)")
    public List<Object[]> findCurrentTodosByUserId(@Param("userId")Long id);
    
    /**
     * Returns a list of total progress (with all finished tasks for each career level)
     * of user.
     * @param id Id of user.
     */
    @Query("select tt, t from TodoType tt, Todo t, User u " +
            "where tt.id = t.todoTypeId and t.primaryKey.user.id = u.id " +
            "and t.primaryKey.user.id = :userId " +
            "order by t.primaryKey.careerLevel.id asc")
    public List<Object[]> findAllFinishedTodosByUserId(@Param("userId")Long id);
    
    /**
     * Returns number of all todos that user has to complete (for his current
     * career level)
     * @param id User id.
     */
    @Query("select count(ct.primaryKey.todoType.id) from CareerLevelTodo ct, User u " +
    "where u.careerLevel.id = ct.primaryKey.careerLevel.id and u.id = :userId")
public int findNumberOfTotalTodosByUserId(@Param("userId")Long id);
    
    /**
     * Returns number of all todos that user has completed (for his current
     * career level)
     * 
     * @param id User id.
     */
    @Query("select count(t.primaryKey.todoId) from Todo t " +
                "where t.primaryKey.user.id = :userId")
    public int findNumberOfFinishedTodosByUserId(@Param("userId")Long id);
    
    /**
     * Returns all instances of CareerLevelTodo entity.
     */
    @Query("select ct from CareerLevelTodo ct")
    public List<CareerLevelTodo> findAllCareerLevelTodos();
    
    /**
     * Returns a specific instance of CareerLevelTodo entity.
     * @param careerLevelId If of career level.
     * @param todoTypeId Id of todo type.
     */
    @Query("select ct from CareerLevelTodo ct " +
            "where ct.primaryKey.careerLevel.id = :careerLevelId " +
            "and ct.primaryKey.todoType.id = :todoTypeId")
    public CareerLevelTodo findCareerLevelTodo(
            @Param("careerLevelId")Long careerLevelId,
            @Param("todoTypeId")Long todoTypeId);
}
