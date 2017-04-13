package com.inthergroup.internship.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inthergroup.internship.models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query ("select t from Todo t where t.primaryKey.user.id = :userId " +
            "and t.primaryKey.careerLevel.id = :careerLevelId " +
            "and t.primaryKey.todoId = :todoId")
    Todo findTodo(@Param("userId")Long userId,
            @Param("careerLevelId")Long careerLevelId, @Param("todoId")String todoId);
    
    @Query("select name from TodoType where id in " +
            "(select ct.primaryKey.todoType.id from CareerLevelTodo ct " +
            "where ct.primaryKey.careerLevel.id = ?1)")
    public List<String> findTodosFromLevel(Long id);
    
    @Query("select tt, t from TodoType tt, Todo t, User u " +
            "where tt.id = t.todoTypeId and t.primaryKey.user.id = u.id " +
            "and t.primaryKey.user.id = :userId " +
            "and t.primaryKey.careerLevel.id = u.careerLevel.id")
    public List<Object[]> findCurrentFinishedTodosByUserId(@Param("userId")Long id);
    
//    @Query("select tt, ct from TodoType tt, CareerLevelTodo ct, User u, Todo t " +
//            "where tt.id = ct.primaryKey.todoType.id " +
//            "and ct.primaryKey.careerLevel.id = u.careerLevel.id " +
//            "and u.careerLevel.id = t.primaryKey.careerLevel.id " +
//            "and t.primaryKey.user.id = :userId " +
//            "and u.id = :userId ")
//    public List<Object[]> findCurrentTodosByUserId(@Param("userId")Long id);
    
    /**
     * Returns number of current unfinished tasks.
     * 
     * @param id The User id.
     * @return
     */
    @Query("select tt, ct from TodoType tt, CareerLevelTodo ct, User u " +
            "where tt.id = ct.primaryKey.todoType.id " +
            "and ct.primaryKey.careerLevel.id = u.careerLevel.id " +
            "and u.id = :userId and ct.primaryKey.todoType.id not in " +
            "(select t.todoTypeId from Todo t where t.primaryKey.user.id = :userId)")
    public List<Object[]> findCurrentTodosByUserId(@Param("userId")Long id);
    
    @Query("select tt, t from TodoType tt, Todo t, User u " +
            "where tt.id = t.todoTypeId and t.primaryKey.user.id = u.id " +
            "and t.primaryKey.user.id = :userId " +
            "order by t.primaryKey.careerLevel.id asc")
    public List<Object[]> findAllFinishedTodosByUserId(@Param("userId")Long id);
    
//    @Query("select count(ct.primaryKey.todoType.id) as nbTodoTypes " +
//            "from CareerLevelTodo ct group by ct.primaryKey.careerLevel.id " +
//            "order by nbTodoTypes asc")
//    public int[] findNumberOfTodoTypesForEachCareerLevel();
    
    @Query("select count(ct.primaryKey.todoType.id) from CareerLevelTodo ct, User u " +
    "where u.careerLevel.id = ct.primaryKey.careerLevel.id and u.id = :userId")
public int findNumberOfTotalTodosByUserId(@Param("userId")Long id);
    
    
    @Query("select count(t.primaryKey.todoId) from Todo t " +
                "where t.primaryKey.user.id = :userId")
    public int findNumberOfFinishedTodosByUserId(@Param("userId")Long id);
}
