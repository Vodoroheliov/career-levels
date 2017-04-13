package com.inthergroup.internship.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.inthergroup.internship.models.BenefitType;
import com.inthergroup.internship.models.CareerLevel;
import com.inthergroup.internship.repositories.BenefitRepository;
import com.inthergroup.internship.repositories.CareerLevelRepository;

@Service
@Primary
public class BenefitServiceJpaImpl implements BenefitService {
    @Autowired
    private BenefitRepository benefitRepo;
    
    @Autowired
    private CareerLevelRepository careerLevelRepo;

    @Override
    public List<BenefitType> findAll() {
        return this.benefitRepo.findAll();
    }

    @Override
    public BenefitType findById(Long id) {
        return this.benefitRepo.findOne(id);
    }

    @Override
    public BenefitType create(BenefitType benefit) {
        return this.benefitRepo.save(benefit);
    }

    @Override
    public BenefitType edit(BenefitType benefit) {
        return this.benefitRepo.save(benefit);
    }

    @Override
    public void deleteById(Long id) {
        this.benefitRepo.delete(id);
    }

    @Override
    public void addBenefitToCareerLevel(Long careerLevelId, Long benefitTypeId,
            Integer quantity) {
        BenefitType benefitType = benefitRepo.findOne(benefitTypeId);
        CareerLevel careerLevel = careerLevelRepo.findOne(careerLevelId);
        careerLevel.addBenefit(benefitType, quantity);
    }

    @Override
    public void removeBenefitFromCareerLevel(Long careerLevelId, Long benefitTypeId) {
        BenefitType benefitType = benefitRepo.findOne(benefitTypeId);
        CareerLevel careerLevel = careerLevelRepo.findOne(careerLevelId);
        careerLevel.removeBenefit(benefitType);
    }

    @Override
    public List<String> findBenefitsFromLevel(Long id) {
        return this.benefitRepo.findBenefitsFromLevel(id);
    }
}
