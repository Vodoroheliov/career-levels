package com.inthergroup.internship.services;

import com.inthergroup.internship.models.User;
import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * Returns all instances of User entity.
     * @return
     */
    List<User> findAll();

    /**
     * Returns instance of User entity using his id.
     * @param id User id.
     */
    User findById(Long id);
    
    /**
     * Returns instance of User entity using his username.
     * @param username Username.
     */
    User findByUsername(String username);

    /**
     * Saves instance of User entity.
     */
    User create(User user);

    /**
     * Saves instance of User entity.
     */
    User edit(User user);

    /**
     * Deletes instance of User entity by his id.
     * @param id
     */
    void deleteById(Long id);
    
    /**
     * Returns list of instances of User entity from a specific career level.
     * @param id Career level id.
     * @return
     */
    List<User> findUsersFromLevel(Long id);
    
    /**
     * Returns map with percent progress for corresponding user id.
     */
    Map<String, Integer> findUsersPercentProgress();
}
