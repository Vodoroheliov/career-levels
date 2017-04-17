package com.inthergroup.internship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inthergroup.internship.models.BenefitType;
import com.inthergroup.internship.models.CareerLevelBenefit;
import com.inthergroup.internship.models.CareerLevelTodo;
import com.inthergroup.internship.models.TodoType;
import com.inthergroup.internship.services.BenefitService;
import com.inthergroup.internship.services.CareerLevelService;

@Controller
public class BenefitController {
    
    @Autowired
    private BenefitService benefitService;
    
    @Autowired
    private CareerLevelService careerLevelService;
    
    @RequestMapping("/benefits/all-benefits")
    public String benefits(Model model) {
        model.addAttribute("benefits", benefitService.findAllCareerLevelBenefits());
        model.addAttribute("careerLevels", careerLevelService.findAll());
        model.addAttribute("benefitTypes", benefitService.findAll());
        return "/benefits/all-benefits";
    }
    
    @RequestMapping("/benefits/benefit-type")
    public String benefit_type(Model model) {
        model.addAttribute("benefitTypes", benefitService.findAll());
        return "/benefits/benefit-type";
    }
    
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
    
    // You must delete benefit only after you deleted it from all
    // users that contained it.
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
