package com.inthergroup.internship.services;

import com.inthergroup.internship.models.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User create(User user);

    User edit(User user);

    void deleteById(Long id);
    
    List<User> findUsersFromLevel(Long id);
}
