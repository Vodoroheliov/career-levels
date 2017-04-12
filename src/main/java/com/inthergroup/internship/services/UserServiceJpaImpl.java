package com.inthergroup.internship.services;

import com.inthergroup.internship.models.User;
import com.inthergroup.internship.repositories.TodoRepository;
import com.inthergroup.internship.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class UserServiceJpaImpl implements UserService {
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private TodoRepository todoRepo;

    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userRepo.findOne(id);
    }

    @Override
    public User create(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public User edit(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepo.delete(id);
    }
    
    @Override
    public List<User> findUsersFromLevel(Long id) {
        return userRepo.findByCareerLevelId(id);
    }

    /**
     * For each user find progress in percent.
     * 
     * @return
     */
    @Override
    public Map<String, Integer> findUsersPercentProgress() {
        // Map consisting of user id (String) and appropriate percent progress (Integer) 
        HashMap<String, Integer> usersPercentProgress = new HashMap<>();
        
        // array of all uesr ids (ordered by asc)
        long[] userIds = new long[userRepo.findNumberOfUserIds()];
        userIds = userRepo.findUserIds();
        
        // array of total number of todos for each level
        int[] nbTotalTodosForEachUser = new int[userIds.length];
        for (int i = 0; i < nbTotalTodosForEachUser.length; i++) {
            nbTotalTodosForEachUser[i] =
                    todoRepo.findNumberOfTotalTodosByUserId(userIds[i]);
        }
        
        // array of number of finished todos for each user
        int[] nbFinishedTodosForEachUser = new int[userIds.length];
        for (int i = 0; i < nbFinishedTodosForEachUser.length; i++) {
            nbFinishedTodosForEachUser[i] =
                    todoRepo.findNumberOfFinishedTodosByUserId(userIds[i]);
        }
        
        // Find percent progress for each user
        for (int i = 0; i < nbFinishedTodosForEachUser.length; i++) {
            double percent =
                    (double) nbFinishedTodosForEachUser[i] /
                    (double) nbTotalTodosForEachUser[i] * 100;
            usersPercentProgress.put(String.valueOf(userIds[i]), (int) percent);
        }
        
        return usersPercentProgress;
    }
}
