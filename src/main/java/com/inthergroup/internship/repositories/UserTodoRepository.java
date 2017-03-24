package com.inthergroup.internship.repositories;

import com.inthergroup.internship.models.UserTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Deprecated
@Repository
public interface UserTodoRepository extends JpaRepository<UserTodo, Long> {
}
