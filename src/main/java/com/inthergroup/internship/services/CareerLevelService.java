package com.inthergroup.internship.services;

import java.util.List;

import com.inthergroup.internship.models.CareerLevel;

public interface CareerLevelService {
    /**
     * Returns a list of all instances of CareerLevel entity.
     * @return
     */
    List<CareerLevel> findAll();

    /**
     * Returns a specific instance of CareerLevel entity.
     * @param id Id of career level.
     */
    CareerLevel findById(Long id);

    /**
     * Saves new instance of CareerLevel entity.
     */
    CareerLevel create(CareerLevel careerLevel);

    /**
     * Saves new instance of CareerLevel entity.
     */
    CareerLevel edit(CareerLevel careerLevel);

    /**
     * Deletes career level using his id.
     * @param id
     */
    void deleteById(Long id);
    
    /**
     * Updates user career level.
     * @param userId User id.
     * @param careerLevelId Career level id.
     */
    void updateUserCareerLevel(long userId, long careerLevelId);

    /**
     * Returns a list of all instances of CareerLevel entity ordered by id ascending.
     * @return
     */
    List<CareerLevel> findAllByOrderByIdAsc();
    
    /**
     * Returns a specific instance of CareerLevel entity.
     * @param userId User id.
     */
    CareerLevel findCareerLevelByUserId(Long userId);
}
