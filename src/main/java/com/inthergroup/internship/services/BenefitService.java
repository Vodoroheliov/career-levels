package com.inthergroup.internship.services;

import java.util.List;

import com.inthergroup.internship.models.BenefitType;

public interface BenefitService {
    List<BenefitType> findAll();

    BenefitType findById(Long id);

    BenefitType create(BenefitType benefit);

    BenefitType edit(BenefitType benefit);

    void deleteById(Long id);
    
    void addBenefitToUser(Long userId, Long benefitId);

    void removeBenefitFromUser(Long userId, Long benefitId);

    void addBenefitToCareerLevel(Long careerLevelId, Long benefitId);

    void removeBenefitFromCareerLevel(Long careerLevelId, Long benefitId);

    List<String> findBenefitsFromLevel(Long id);
}
