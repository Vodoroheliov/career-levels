package com.inthergroup.internship.services;

import java.util.List;

import com.inthergroup.internship.models.Group;

public interface GroupService {
    List<Group> findAll();

    Group findById(Long id);

    Group create(Group group);

    Group edit(Group group);

    void deleteById(Long id);
}
