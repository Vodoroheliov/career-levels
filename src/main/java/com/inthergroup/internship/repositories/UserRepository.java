package com.inthergroup.internship.repositories;

import com.inthergroup.internship.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("select name from TodoType where id in " +
//            "(select ct.primaryKey.todoType.id from CareerLevelTodo ct " +
//            "where ct.primaryKey.careerLevel.id = ?1)")
//    public List<String> findTodosFromLevel(Long id);
//    List<String> findUsersFromLevel(Long id);
    public List<User> findByCareerLevelId(Long id);
    
    @Query("select count(u.id) from User u")
    public int findNumberOfUserIds();
    
    @Query("select u.id from User u order by u.id asc")
    public long[] findUserIds();
}
