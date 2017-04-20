package com.inthergroup.internship.services;

import java.util.List;

import com.inthergroup.internship.models.BenefitType;
import com.inthergroup.internship.models.CareerLevelBenefit;

public interface BenefitService {
    /**
     * Returns a list of all instances of BenefitType entity.
     * @return
     */
    List<BenefitType> findAll();

    /**
     * Finds and returns a specifc BenefitType by his id.
     * @param id
     * @return
     */
    BenefitType findById(Long id);

    /**
     * Creates new benefit type.
     */
    BenefitType create(BenefitType benefitType);

    /**
     * Saves changes made to instance of BenefitType entity.
     * @param benefitType
     * @return
     */
    BenefitType edit(BenefitType benefitType);

    /**
     * Finds and deletes BenefitType by his id.
     * @param id
     */
    void deleteById(Long id);

    /**
     * Adds benefit to specific career level.
     * @param careerLevelId Id of career level.
     * @param benefitTypeId Id of benefit type.
     * @param quantity The number of these benefit types.
     */
    void addBenefitToCareerLevel(Long careerLevelId, Long benefitTypeId,
            Integer quantity);

    /**
     * Removes benefit from a specific career level.
     * @param careerLevelId Id of career level.
     * @param benefitTypeId Id of benefit type.
     */
    void removeBenefitFromCareerLevel(Long careerLevelId, Long benefitTypeId);

//    /**
//     * Returns list of all benefits from a specifc career level.
//     * @param id
//     */
//    List<BenefitType> findBenefitTypesFromLevel(Long id);
//    
//    /**
//     * Returns list of instances of CareerLevelBenefit entity that belong to
//     * specific career level.
//     * @param id Career level id.
//     */
//    List<CareerLevelBenefit> findCareerLevelBenefitsFromLevel(Long id);
    
    /**
     * Returns list of arrays that consist of quantity and benefit type names
     * for specific career level.
     * 1st element in array - quantity.
     * 2nd element in array - name of benefit type.
     * @param id Career level id.
     */
    List<Object[]> findBenefitsFromLevel(Long id);
    
    /**
     * Returns all instances of CareerLevelBenefit entity.
     */
    List<CareerLevelBenefit> findAllCareerLevelBenefits();
    
    /**
     * Returns a specifc instance of CareerLevelBenefit entity.
     * @param careerLevelId Id of career level.
     * @param benefitTypeId Id of benefit type.
     */
    CareerLevelBenefit findCareerLevelBenefit(Long careerLevelId, Long benefitTypeId);
    
}
