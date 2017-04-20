package com.inthergroup.internship.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.inthergroup.internship.models.BenefitType;
import com.inthergroup.internship.models.CareerLevel;
import com.inthergroup.internship.models.CareerLevelBenefit;
import com.inthergroup.internship.repositories.BenefitTypeRepository;
import com.inthergroup.internship.repositories.CareerLevelRepository;

@Service
@Primary
public class BenefitServiceJpaImpl implements BenefitService {
    @Autowired
    private BenefitTypeRepository benefitTypeRepo;
    
    @Autowired
    private CareerLevelRepository careerLevelRepo;

    @Override
    public List<BenefitType> findAll() {
        return this.benefitTypeRepo.findAllByOrderByIdAsc();
    }

    @Override
    public BenefitType findById(Long id) {
        return this.benefitTypeRepo.findOne(id);
    }

    @Override
    public BenefitType create(BenefitType benefit) {
        return this.benefitTypeRepo.save(benefit);
    }

    @Override
    public BenefitType edit(BenefitType benefit) {
        return this.benefitTypeRepo.save(benefit);
    }

    @Override
    public void deleteById(Long id) {
        this.benefitTypeRepo.delete(id);
    }

    @Override
    public void addBenefitToCareerLevel(Long careerLevelId, Long benefitTypeId,
            Integer quantity) {
        BenefitType benefitType = benefitTypeRepo.findOne(benefitTypeId);
        CareerLevel careerLevel = careerLevelRepo.findOne(careerLevelId);
        careerLevel.addBenefit(benefitType, quantity);
    }

    @Override
    public void removeBenefitFromCareerLevel(Long careerLevelId, Long benefitTypeId) {
        BenefitType benefitType = benefitTypeRepo.findOne(benefitTypeId);
        CareerLevel careerLevel = careerLevelRepo.findOne(careerLevelId);
        careerLevel.removeBenefit(benefitType);
    }

//    @Override
//    public List<BenefitType> findBenefitTypesFromLevel(Long id) {
//        return this.benefitTypeRepo.findBenefitTypesFromLevel(id);
//    }
//    
//    @Override
//    public List<CareerLevelBenefit> findCareerLevelBenefitsFromLevel(Long id) {
//        return benefitTypeRepo.findCareerLevelBenefitsFromLevel(id);
//    }

    @Override
    public List<Object[]> findBenefitsFromLevel(Long id) {
        return benefitTypeRepo.findBenefitsFromLevel(id);
    }
    
    @Override
    public List<CareerLevelBenefit> findAllCareerLevelBenefits() {
        return benefitTypeRepo.findAllCareerLevelBenefits();
    }

    @Override
    public CareerLevelBenefit findCareerLevelBenefit(
            Long careerLevelId, Long benefitTypeId) {
        return benefitTypeRepo.findCareerLevelBenefit(careerLevelId, benefitTypeId);
    }
}
