package com.inthergroup.internship.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inthergroup.internship.models.BenefitType;
import com.inthergroup.internship.models.CareerLevelBenefit;

@Repository
public interface BenefitTypeRepository extends JpaRepository<BenefitType, Long> {
    
    /**
     * Returns list of all benefits from specific career level.
     * 
     * @param id Id of career level.
     */
    @Query("select name from BenefitType where id in " +
            "(select cb.primaryKey.benefitType.id from CareerLevelBenefit cb " +
            "where cb.primaryKey.careerLevel.id = ?1)")
    public List<String> findBenefitsFromLevel(Long id);
    
    /**
     * Returns list of all instances of CareerLevelBenefit entity.
     */
    @Query("select cb from CareerLevelBenefit cb")
    public List<CareerLevelBenefit> findAllCareerLevelBenefits();
    
    /**
     * Returns a specific instance of CareerLevelBenefit entity.
     * 
     * @param careerLevelId Id of career level.
     * @param benefitTypeId Id of benefit type.
     */
    @Query("select cb from CareerLevelBenefit cb " +
            "where cb.primaryKey.careerLevel.id = :careerLevelId " +
            "and cb.primaryKey.benefitType.id = :benefitTypeId")
    public CareerLevelBenefit findCareerLevelBenefit(
            @Param("careerLevelId")Long careerLevelId,
            @Param("benefitTypeId")Long benefitTypeId);
    
    /**
     * Returns list of all instances of BenefitType entity ordered by Id Ascending.
     */
    public List<BenefitType> findAllByOrderByIdAsc();
}
