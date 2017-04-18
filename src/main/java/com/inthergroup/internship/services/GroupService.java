package com.inthergroup.internship.services;

import java.util.List;

import com.inthergroup.internship.models.Group;

public interface GroupService {
    
    /**
     * Returns a list of all instances of Group entity.
     */
    List<Group> findAll();

    /**
     * Returns a specific instance of Group entity.
     * @param id Group id.
     */
    Group findById(Long id);

    /**
     * Saves instance of Group entity.
     */
    Group create(Group group);

    /**
     * Saves instance of Group entity.
     */
    Group edit(Group group);

    /**
     * Deletes instance of Group entity using his id.
     * @param id
     */
    void deleteById(Long id);
    
    /**
     * Updates group for a specific user.
     * @param userId User id.
     * @param groupId Gorup id.
     */
    void updateUserGroup(long userId, long groupId);
}
