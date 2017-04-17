package com.inthergroup.internship.services;

import java.util.List;

import com.inthergroup.internship.models.BenefitType;
import com.inthergroup.internship.models.CareerLevelBenefit;

public interface BenefitService {
    List<BenefitType> findAll();

    BenefitType findById(Long id);

    BenefitType create(BenefitType benefit);

    BenefitType edit(BenefitType benefit);

    void deleteById(Long id);

    void addBenefitToCareerLevel(Long careerLevelId, Long benefitTypeId,
            Integer quantity);

    void removeBenefitFromCareerLevel(Long careerLevelId, Long benefitTypeId);

    List<String> findBenefitsFromLevel(Long id);
    
    List<CareerLevelBenefit> findAllCareerLevelBenefits();
    
    CareerLevelBenefit findCareerLevelBenefit(Long careerLevelId, Long benefitTypeId);
}
