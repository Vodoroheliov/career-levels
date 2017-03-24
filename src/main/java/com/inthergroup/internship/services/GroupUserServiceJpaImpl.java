package com.inthergroup.internship.services;

import com.inthergroup.internship.models.GroupUser;
import com.inthergroup.internship.repositories.GroupUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;

@Deprecated
@Service
@Primary
public class GroupUserServiceJpaImpl implements GroupUserService {
    @Autowired
    private GroupUserRepository groupUserRepo;

    @Override
    public List<GroupUser> findAll() {
        return this.groupUserRepo.findAll();
    }

    @Override
    public GroupUser findById(Long id) {
        return this.groupUserRepo.findOne(id);
    }

    @Override
    public GroupUser create(GroupUser GroupUser) {
        return this.groupUserRepo.save(GroupUser);
    }

    @Override
    public GroupUser edit(GroupUser GroupUser) {
        return this.groupUserRepo.save(GroupUser);
    }

    @Override
    public void deleteById(Long id) {
        this.groupUserRepo.delete(id);
    }
}
