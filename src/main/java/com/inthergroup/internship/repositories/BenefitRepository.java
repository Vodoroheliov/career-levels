package com.inthergroup.internship.repositories;

import com.inthergroup.internship.models.BenefitType;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitRepository extends JpaRepository<BenefitType, Long> {
    @Query("select name from BenefitType where id in " +
            "(select cb.primaryKey.benefitType.id from CareerLevelBenefit cb " +
            "where cb.primaryKey.careerLevel.id = ?1)")
    public List<String> findBenefitsFromLevel(Long id);
}
