package com.inthergroup.internship.services;

import java.util.List;

import com.inthergroup.internship.models.UserTodo;

@Deprecated
public interface UserTodoService {
    List<UserTodo> findAll();

    UserTodo findById(Long id);

    UserTodo create(UserTodo userTodo);

    UserTodo edit(UserTodo userTodo);

    void deleteById(Long id);
}
