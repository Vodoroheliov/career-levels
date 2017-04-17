package com.inthergroup.internship.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inthergroup.internship.models.TodoType;

@Repository
public interface TodoTypeRepository extends JpaRepository<TodoType, Long> {
    
    public List<TodoType> findAllByOrderByIdAsc();
}
