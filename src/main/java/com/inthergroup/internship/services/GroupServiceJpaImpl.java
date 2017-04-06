package com.inthergroup.internship.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inthergroup.internship.models.Group;
import com.inthergroup.internship.models.User;
import com.inthergroup.internship.repositories.GroupRepository;
import com.inthergroup.internship.repositories.UserRepository;

@Service
@Primary
public class GroupServiceJpaImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepo;
    
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Group> findAll() {
        return this.groupRepo.findAll();
    }

    @Override
    public Group findById(Long id) {
        return this.groupRepo.findOne(id);
    }

    @Override
    public Group create(Group group) {
        return this.groupRepo.save(group);
    }

    @Override
    public Group edit(Group group) {
        return this.groupRepo.save(group);
    }

    @Override
    public void deleteById(Long id) {
        this.groupRepo.delete(id);
    }

    @Override
    @Transactional
    public void updateUserGroup(long userId, long groupId) {
        Group group = groupRepo.findOne(groupId);
        User user = userRepo.findOne(userId);
        user.setGroup(group);
    }
    
//    @Override
//    public void addGroupToUser(Long userId, Long groupId) {
//        Group group = groupRepo.findOne(groupId);
//        User user = userRepo.findOne(userId);
//        user.addGroup(group);
//    }
//    
//    public void removeGroupFromUser(Long userId, Long todoId) {
//        Group group = groupRepo.findOne(todoId);
//        User user = userRepo.findOne(userId);
//        user.removeGroup(group);
//    }
}
