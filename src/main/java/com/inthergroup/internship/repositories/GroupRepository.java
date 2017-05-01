package com.inthergroup.internship.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inthergroup.internship.models.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    
    public Group findByRole(String role);
}
