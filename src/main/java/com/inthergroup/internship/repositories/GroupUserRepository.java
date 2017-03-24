package com.inthergroup.internship.repositories;

import com.inthergroup.internship.models.GroupUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Deprecated
@Repository
public interface GroupUserRepository extends JpaRepository<GroupUser, Long> {
}
