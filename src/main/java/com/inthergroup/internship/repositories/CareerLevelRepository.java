package com.inthergroup.internship.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inthergroup.internship.models.CareerLevel;

@Repository
public interface CareerLevelRepository extends JpaRepository<CareerLevel, Long> {
    public List<CareerLevel> findAllByOrderByIdAsc();
    
    @Query("select c from CareerLevel c, User u " +
    "where u.careerLevel.id = c.id and u.id = :userId")
    public CareerLevel findCareerLevelByUserId(@Param("userId")Long id);
}
