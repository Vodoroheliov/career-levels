package com.inthergroup.internship.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inthergroup.internship.models.CareerLevelTodo;

@Repository
public interface CareerLevelTodoRepository
        extends JpaRepository<CareerLevelTodo, Long> {
}
