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
    
//    /**
//     * Returns list of all benefits from specific career level.
//     * 
//     * @param id Id of career level.
//     */
//    @Query("select bt from BenefitType bt where bt.id in " +
//            "(select cb.primaryKey.benefitType.id from CareerLevelBenefit cb " +
//            "where cb.primaryKey.careerLevel.id = ?1)")
//    public List<BenefitType> findBenefitTypesFromLevel(Long id);
//    
//    /**
//     * Returns list of instances of CareerLevelBenefit entity that belong to
//     * specific career level.
//     * @param id Career level id.
//     */
//    @Query("select cb from CareerLevelBenefit cb " +
//            "where cb.primaryKey.careerLevel.id = ?1")
//    public List<CareerLevelBenefit> findCareerLevelBenefitsFromLevel(Long id);
    
    /**
     * Returns list of arrays that consist of quantity and benefit type names
     * for specific career level.
     * 1st element in array - quantity.
     * 2nd element in array - name of benefit type.
     * @param id Career level id.
     */
    @Query("select cb.quantity, bt.name " +
            "from CareerLevelBenefit cb, BenefitType bt " +
            "where cb.primaryKey.benefitType.id = bt.id " +
            "and cb.primaryKey.careerLevel.id = ?1")
    public List<Object[]> findBenefitsFromLevel(Long id);
    
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
