package com.inthergroup.internship.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.inthergroup.internship.models.CareerLevel;
import com.inthergroup.internship.repositories.CareerLevelRepository;

@Service
@Primary
public class CareerLevelServiceJpaImpl implements CareerLevelService {
    @Autowired
    private CareerLevelRepository careerLevelRepo;

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
}
