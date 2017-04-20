package com.inthergroup.internship.services;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.inthergroup.internship.models.CareerLevel;
import com.inthergroup.internship.models.CareerLevelTodo;
import com.inthergroup.internship.models.Todo;
import com.inthergroup.internship.models.TodoType;
import com.inthergroup.internship.models.User;
import com.inthergroup.internship.repositories.CareerLevelRepository;
import com.inthergroup.internship.repositories.CareerLevelTodoRepository;
import com.inthergroup.internship.repositories.TodoRepository;
import com.inthergroup.internship.repositories.TodoTypeRepository;
import com.inthergroup.internship.repositories.UserRepository;

@Service
@Primary
public class TodoServiceJpaImpl implements TodoService {
    
    // -----------------
    // Fields
    // -----------------
    
    @Autowired
    private TodoTypeRepository todoTypeRepo;
    
    @Autowired
    private TodoRepository todoRepo;
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private CareerLevelRepository careerLevelRepo;
    
    @Autowired
    private CareerLevelTodoRepository careerLevelTodoRepo;
    
    // ----------------
    // Methods
    // ----------------
    
    @Override
    public TodoType findTodoTypeById(Long id) {
        return this.todoTypeRepo.findOne(id);
    }

    @Override
    public List<TodoType> findAllTodoTypes() {
        return this.todoTypeRepo.findAllByOrderByIdAsc();
    }

    @Override
    public TodoType createTodoType(TodoType todo) {
        return this.todoTypeRepo.save(todo);
    }

    @Override
    public TodoType saveTodoType(TodoType todo) {
        return this.todoTypeRepo.save(todo);
    }

    @Override
    public void deleteTodoTypeById(Long id) {
        this.todoTypeRepo.delete(id);
    }
    
    @Override
    public Todo findTodo(Long userId, Long careerLevelId, String todoId) {
        return todoRepo.findTodo(userId, careerLevelId, todoId);
    }

    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepo.save(todo);
    }

    @Override
    public void addTodoToUser(Long userId, String todoId, Long todoTypeId,
            Date dateOfCompletion, String description) {
        User user = userRepo.findOne(userId);
        user.addTodo(todoId, todoTypeId, dateOfCompletion, description);
    }
    
    @Override
    public void removeTodoFromUser(Long userId, String todoId, Long careerLevelId) {
        User user = userRepo.findOne(userId);
        CareerLevel careerLevel = careerLevelRepo.findOne(careerLevelId);
        user.removeTodo(todoId, careerLevel);
    }

    @Override
    public void addTodoToCareerLevel(Long careerLevelId, Long todoTypeId,
            Integer quantity) {
        TodoType todoType = todoTypeRepo.findOne(todoTypeId);
        CareerLevel careerLevel = careerLevelRepo.findOne(careerLevelId);
        careerLevel.addTodo(todoType, quantity);
    }

    @Override
    public void removeTodoFromCareerLevel(Long careerLevelId, Long todoTypeId) {
        TodoType todoType = todoTypeRepo.findOne(todoTypeId);
        CareerLevel careerLevel = careerLevelRepo.findOne(careerLevelId);
        careerLevel.removeTodo(todoType);
    }

    @Override
    public List<Object[]> findTodosFromLevel(Long id) {
        return todoTypeRepo.findTodosFromLevel(id);
    }

    @Override
    public List<Object[]> findCurrentFinishedTodosByUserId(Long id) {
        return this.todoRepo.findCurrentFinishedTodosByUserId(id);
    }

    @Override
    public List<Object[]> findCurrentTodosByUserId(Long id) {
        return this.todoRepo.findCurrentTodosByUserId(id);
    }

    @Override
    public List<Object[]> findAllFinishedTodosByUserId(Long id) {
        return this.todoRepo.findAllFinishedTodosByUserId(id);
    }

    @Override
    public List<CareerLevelTodo> findAllCareerLevelTodos() {
        return todoRepo.findAllCareerLevelTodos();
    }

    @Override
    public CareerLevelTodo findCareerLevelTodo(Long careerLevelId, Long todoTypeId) {
        return todoRepo.findCareerLevelTodo(careerLevelId, todoTypeId);
    }

    @Override
    public void deleteCareerLevelTodo(CareerLevelTodo careerLevelTodo) {
        careerLevelTodoRepo.delete(careerLevelTodo);
    }
}
