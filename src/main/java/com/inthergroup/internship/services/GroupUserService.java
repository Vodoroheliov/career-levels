package com.inthergroup.internship.services;

import com.inthergroup.internship.models.GroupUser;
import java.util.List;

@Deprecated
public interface GroupUserService {
    List<GroupUser> findAll();

    GroupUser findById(Long id);

    GroupUser create(GroupUser groupUser);

    GroupUser edit(GroupUser groupUser);

    void deleteById(Long id);
}
