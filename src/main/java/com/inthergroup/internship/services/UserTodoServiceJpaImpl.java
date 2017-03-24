package com.inthergroup.internship.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.inthergroup.internship.models.UserTodo;
import com.inthergroup.internship.repositories.UserTodoRepository;

@Deprecated
@Service
@Primary
public class UserTodoServiceJpaImpl implements UserTodoService {
    @Autowired
    private UserTodoRepository userTodoRepo;

    @Override
    public List<UserTodo> findAll() {
        return this.userTodoRepo.findAll();
    }

    @Override
    public UserTodo findById(Long id) {
        return this.userTodoRepo.findOne(id);
    }

    @Override
    public UserTodo create(UserTodo userTodo) {
        return this.userTodoRepo.save(userTodo);
    }

    @Override
    public UserTodo edit(UserTodo userTodo) {
        return this.userTodoRepo.save(userTodo);
    }

    @Override
    public void deleteById(Long id) {
        this.userTodoRepo.delete(id);
    }
}
