package com.inthergroup.internship.repositories;

import com.inthergroup.internship.models.TodoType;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoType, Long> {
    @Query("select name from TodoType where id in " +
            "(select t.id from TodoType t inner join t.careerLevels c where c.id = ?1)")
    public List<String> findTodosFromLevel(Long id);
}
