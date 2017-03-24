package com.inthergroup.internship.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.inthergroup.internship.models.Benefit;
import com.inthergroup.internship.repositories.BenefitRepository;

@Service
@Primary
public class BenefitServiceJpaImpl implements BenefitService {
    @Autowired
    private BenefitRepository benefitRepo;

    @Override
    public List<Benefit> findAll() {
        return this.benefitRepo.findAll();
    }

    @Override
    public Benefit findById(Long id) {
        return this.benefitRepo.findOne(id);
    }

    @Override
    public Benefit create(Benefit benefit) {
        return this.benefitRepo.save(benefit);
    }

    @Override
    public Benefit edit(Benefit benefit) {
        return this.benefitRepo.save(benefit);
    }

    @Override
    public void deleteById(Long id) {
        this.benefitRepo.delete(id);
    }
}
