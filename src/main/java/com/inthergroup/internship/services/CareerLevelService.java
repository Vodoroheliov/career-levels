package com.inthergroup.internship.services;

import java.util.List;

import com.inthergroup.internship.models.CareerLevel;

public interface CareerLevelService {
    List<CareerLevel> findAll();

    CareerLevel findById(Long id);

    CareerLevel create(CareerLevel careerLevel);

    CareerLevel edit(CareerLevel careerLevel);

    void deleteById(Long id);
    
    void updateUserCareerLevel(long userId, long careerLevelId);

    List<CareerLevel> findAllByOrderByIdAsc();
}
