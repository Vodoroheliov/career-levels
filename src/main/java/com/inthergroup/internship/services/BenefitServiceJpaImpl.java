package com.inthergroup.internship.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inthergroup.internship.models.BenefitType;
import com.inthergroup.internship.models.CareerLevel;
import com.inthergroup.internship.models.User;
import com.inthergroup.internship.repositories.BenefitRepository;
import com.inthergroup.internship.repositories.CareerLevelRepository;
import com.inthergroup.internship.repositories.UserRepository;

@Service
@Primary
public class BenefitServiceJpaImpl implements BenefitService {
    @Autowired
    private BenefitRepository benefitRepo;
    
    @Autowired
    private UserRepository userRepo;
    
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
//    @Transactional
    public void addBenefitToUser(Long userId, Long benefitId) {
        BenefitType benefit = benefitRepo.findOne(benefitId);
        User user = userRepo.findOne(userId);
        user.addBenefit(benefit);
    }
    
    @Override
    public void removeBenefitFromUser(Long userId, Long benefitId) {
        BenefitType benefit = benefitRepo.findOne(benefitId);
        User user = userRepo.findOne(userId);
        user.removeBenefit(benefit);
    }

    @Override
    public void addBenefitToCareerLevel(Long careerLevelId, Long benefitId) {
        BenefitType benefit = benefitRepo.findOne(benefitId);
        CareerLevel careerLevel = careerLevelRepo.findOne(careerLevelId);
        careerLevel.addBenefit(benefit);
    }

    @Override
    public void removeBenefitFromCareerLevel(Long careerLevelId, Long benefitId) {
        BenefitType benefit = benefitRepo.findOne(benefitId);
        CareerLevel careerLevel = careerLevelRepo.findOne(careerLevelId);
        careerLevel.removeBenefit(benefit);
    }

    @Override
    public List<String> findBenefitsFromLevel(Long id) {
        return this.benefitRepo.findBenefitsFromLevel(id);
    }
}
