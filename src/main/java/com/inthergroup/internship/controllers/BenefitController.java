package com.inthergroup.internship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inthergroup.internship.models.BenefitType;
import com.inthergroup.internship.services.BenefitService;

@Controller
public class BenefitController {
    
    @Autowired
    private BenefitService benefitService;
    
    @RequestMapping("/create-benefit-type")
    @ResponseBody
    public String createBenefitType(String benefitName) {
        BenefitType benefit = null;
        try {
            benefit = new BenefitType(benefitName);
            benefitService.create(benefit);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error creating the benefit: " + ex.toString();
        }
        return "Benefit succesfully created! (id = " + benefit.getId() + ")";
    }
    
    // You must delete benefit only after you deleted it from all
    // users that contained it.
    @RequestMapping("/delete-benefit-type")
    @ResponseBody
    public String deleteBenefitType(long id) {
        try {
            benefitService.deleteById(id);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error deleting the benefit by id #" + id + ": " + ex.toString();
        }
        return "Benefit succesfully deleted!";
    }
    
    @RequestMapping("/add-benefit-to-career-level")
    @ResponseBody
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
        return "Succesfully added benefit to career level!";
    }
    
    @RequestMapping("/remove-benefit-from-career-level")
    @ResponseBody
    @Transactional
    public String removeBenefitFromCareerLevel(long careerLevelId, long benefitTypeId) {
        try {
            benefitService.removeBenefitFromCareerLevel(careerLevelId, benefitTypeId);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error removing benefit from career level: " + ex.toString();
        }
        return "Succesfully removed benefit from career level!";
    }
    
} // class BenefitController
