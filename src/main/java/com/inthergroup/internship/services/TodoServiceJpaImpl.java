package com.inthergroup.internship.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.inthergroup.internship.models.CareerLevel;
import com.inthergroup.internship.models.TodoType;
import com.inthergroup.internship.models.User;
import com.inthergroup.internship.repositories.CareerLevelRepository;
import com.inthergroup.internship.repositories.TodoRepository;
import com.inthergroup.internship.repositories.UserRepository;

@Service
@Primary
public class TodoServiceJpaImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepo;
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private CareerLevelRepository careerLevelRepo;

    @Override
    public List<TodoType> findAll() {
        return this.todoRepo.findAll();
    }

    @Override
    public TodoType findById(Long id) {
        return this.todoRepo.findOne(id);
    }

    @Override
    public TodoType create(TodoType todo) {
        return this.todoRepo.save(todo);
    }

    @Override
    public TodoType edit(TodoType todo) {
        return this.todoRepo.save(todo);
    }

    @Override
    public void deleteById(Long id) {
        this.todoRepo.delete(id);
    }
    
    @Override
    public void addTodoToUser(Long userId, String todoId, Long todoTypeId,
            Timestamp dateOfCompletion, String description) {
        User user = userRepo.findOne(userId);
        user.addTodo(todoId, todoTypeId, dateOfCompletion, description);
    }
    
    @Override
    public void removeTodoFromUser(Long userId, String todoId, long careerLevelId) {
        User user = userRepo.findOne(userId);
        CareerLevel careerLevel = careerLevelRepo.findOne(careerLevelId);
        user.removeTodo(todoId, careerLevel);
    }

    @Override
    public void addTodoToCareerLevel(Long careerLevelId, Long todoId) {
        TodoType todo = todoRepo.findOne(todoId);
        CareerLevel careerLevel = careerLevelRepo.findOne(careerLevelId);
        careerLevel.addTodo(todo);
    }

    @Override
    public void removeTodoFromCareerLevel(Long careerLevelId, Long todoId) {
        TodoType todo = todoRepo.findOne(todoId);
        CareerLevel careerLevel = careerLevelRepo.findOne(careerLevelId);
        careerLevel.removeTodo(todo);
    }

    @Override
    public List<String> findTodosFromLevel(Long id) {
        return this.todoRepo.findTodosFromLevel(id);
    }
}
