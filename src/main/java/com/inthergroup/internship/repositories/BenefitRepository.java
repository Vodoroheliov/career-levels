package com.inthergroup.internship.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inthergroup.internship.models.BenefitType;
import com.inthergroup.internship.models.CareerLevelBenefit;

@Repository
public interface BenefitRepository extends JpaRepository<BenefitType, Long> {
    @Query("select name from BenefitType where id in " +
            "(select cb.primaryKey.benefitType.id from CareerLevelBenefit cb " +
            "where cb.primaryKey.careerLevel.id = ?1)")
    public List<String> findBenefitsFromLevel(Long id);
    
    @Query("select cb from CareerLevelBenefit cb")
    public List<CareerLevelBenefit> findAllCareerLevelBenefits();
    
    @Query("select cb from CareerLevelBenefit cb " +
            "where cb.primaryKey.careerLevel.id = :careerLevelId " +
            "and cb.primaryKey.benefitType.id = :benefitTypeId")
    public CareerLevelBenefit findCareerLevelBenefit(
            @Param("careerLevelId")Long careerLevelId,
            @Param("benefitTypeId")Long benefitTypeId);
    
    public List<BenefitType> findAllByOrderByIdAsc();
}
