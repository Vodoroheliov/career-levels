package com.inthergroup.internship.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inthergroup.internship.models.CareerLevel;
import com.inthergroup.internship.models.User;
import com.inthergroup.internship.repositories.CareerLevelRepository;
import com.inthergroup.internship.repositories.UserRepository;

@Service
@Primary
public class CareerLevelServiceJpaImpl implements CareerLevelService {
    
    @Autowired
    private CareerLevelRepository careerLevelRepo;
    
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<CareerLevel> findAll() {
        return this.careerLevelRepo.findAll();
    }

    @Override
    public CareerLevel findById(Long id) {
        return this.careerLevelRepo.findOne(id);
    }

    @Override
    public CareerLevel create(CareerLevel careerLevel) {
        return this.careerLevelRepo.save(careerLevel);
    }

    @Override
    public CareerLevel edit(CareerLevel careerLevel) {
        return this.careerLevelRepo.save(careerLevel);
    }

    @Override
    public void deleteById(Long id) {
        this.careerLevelRepo.delete(id);
    }
    
    @Override
    @Transactional
    public void updateUserCareerLevel(long userId, long careerLevelId) {
        CareerLevel careerLevel = careerLevelRepo.findOne(careerLevelId);
        User user = userRepo.findOne(userId);
        user.setCareerLevel(careerLevel);
    }
    
    @Override
    public List<CareerLevel> findAllByOrderByIdAsc() {
        return careerLevelRepo.findAllByOrderByIdAsc();
    }
}
