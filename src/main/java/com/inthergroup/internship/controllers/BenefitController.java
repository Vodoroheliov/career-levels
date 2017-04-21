package com.inthergroup.internship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inthergroup.internship.models.BenefitType;
import com.inthergroup.internship.models.CareerLevelBenefit;
import com.inthergroup.internship.services.BenefitService;
import com.inthergroup.internship.services.CareerLevelService;

@Controller
public class BenefitController {
    
    @Autowired
    private BenefitService benefitService;
    
    @Autowired
    private CareerLevelService careerLevelService;
    
    /**
     * Prepares data for page with all benefits list.
     */
    @RequestMapping("/benefits/all-benefits")
    public String benefits(Model model) {
        model.addAttribute("benefits", benefitService.findAllCareerLevelBenefits());
        model.addAttribute("careerLevels", careerLevelService.findAll());
        model.addAttribute("benefitTypes", benefitService.findAll());
        return "/benefits/all-benefits";
    }
    
    /**
     * Prepares data for page with all benefit types list.
     */
    @RequestMapping("/benefits/benefit-type")
    public String benefit_type(Model model) {
        model.addAttribute("benefitTypes", benefitService.findAll());
        return "/benefits/benefit-type";
    }
    
    /**
     * Creates new benefit type.
     */
    @RequestMapping("/create-benefit-type")
    public String createBenefitType(String benefitName) {
        BenefitType benefit = null;
        try {
            benefit = new BenefitType(benefitName);
            benefitService.create(benefit);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error creating the benefit: " + ex.toString();
        }
        return "redirect:/benefits/benefit-type";
    }
    
    /**
     * Updates existing benefit type.
     * @param benefitTypeId Id of benefit type to update.
     * @param newBenefitName New name of benefit type.
     */
    @RequestMapping("/update-benefit-type")
    public String updateBenefitType(Long benefitTypeId, String newBenefitName) {
        BenefitType benefitType = null;
        try {
            benefitType = benefitService.findById(benefitTypeId);
            benefitType.setName(newBenefitName);
            benefitService.edit(benefitType);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                "Error creating the Benefit Type: " + ex.toString();
        }
        return "redirect:/benefits/benefit-type";
    }
    
    /**
     * Deletes benefit type.
     * 
     * @param id Id of benefit type.
     */
    @RequestMapping("/delete-benefit-type")
    public String deleteBenefitType(long id) {
        try {
            benefitService.deleteById(id);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error deleting the benefit by id #" + id + ": " + ex.toString();
        }
        return "redirect:/benefits/benefit-type";
    }
    
    /**
     * Adds new benefit to career level.
     * 
     * @param careerLevelId Id of career level.
     * @param benefitTypeId Id of benefit type.
     * @param quantity The number of these benefits.
     * @return
     */
    @RequestMapping("/add-benefit-to-career-level")
    @Transactional
    public String addBenefitToCareerLevel(long careerLevelId, long benefitTypeId,
            int quantity) {
        try {
            benefitService.addBenefitToCareerLevel(careerLevelId, benefitTypeId,
                    quantity);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error adding benefit to career level: " + ex.toString();
        }
        return "redirect:/benefits/all-benefits";
    }
    
    /**
     * Updates benefit for a specific career level.
     * 
     * @param oldCareerLevelId Previous career level id.
     * @param oldBenefitTypeId Previous benefit type id.
     * @param newCareerLevelId Substitutional career level id.
     * @param newBenefitTypeId Substitutional benefit type id.
     * @param quantity Substitutional number of benefits.
     * @return
     */
    @RequestMapping(value = "/update-benefit-for-career-level", method = RequestMethod.GET)
    @Transactional
    public String updateBenefitForCareerLevel(
            Long oldCareerLevelId, Long oldBenefitTypeId,
            Long newCareerLevelId, Long newBenefitTypeId,
            int quantity) {
        try {
            if (oldCareerLevelId == newCareerLevelId &&
                    oldBenefitTypeId == newBenefitTypeId) {
                CareerLevelBenefit careerLevelBenefit =
                        benefitService.findCareerLevelBenefit(oldCareerLevelId,
                                oldBenefitTypeId);
                careerLevelBenefit.setQuantity(quantity);
            }
            else {
                benefitService.removeBenefitFromCareerLevel(oldCareerLevelId, oldBenefitTypeId);
                benefitService.addBenefitToCareerLevel(newCareerLevelId, newBenefitTypeId,
                        quantity);
            }
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error adding todo to career level: " + ex.toString();
        }
        return "redirect:/benefits/all-benefits";
    }
    
    /**
     * Removes benefit from a specific career level.
     * 
     * @param careerLevelId Id of career level.
     * @param benefitTypeId Id of benefit type.
     * @return
     */
    @RequestMapping("/remove-benefit-from-career-level")
    @Transactional
    public String removeBenefitFromCareerLevel(Long careerLevelId, Long benefitTypeId) {
        try {
            benefitService.removeBenefitFromCareerLevel(careerLevelId, benefitTypeId);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error removing benefit from career level: " + ex.toString();
        }
        return "redirect:/benefits/all-benefits";
    }
    
} // class BenefitController
