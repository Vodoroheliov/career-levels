package com.inthergroup.internship.repositories;

import com.inthergroup.internship.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * Returns a specifc user by his name.
     * 
     * @param username Username.
     */
    public User findByUsername(String username);

    /**
     * Returns a specifc user by his id.
     * 
     * @param id User id.
     */
    public List<User> findByCareerLevelId(Long id);
    
    /**
     * Returns number of all user's ids.
     */
    @Query("select count(u.id) from User u")
    public int findNumberOfUserIds();
    
    /**
     * Returns an array of all user ids ordered by id ascending.
     * @return
     */
    @Query("select u.id from User u order by u.id asc")
    public long[] findUserIds();
}
