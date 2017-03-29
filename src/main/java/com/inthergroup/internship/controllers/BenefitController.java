package com.inthergroup.internship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inthergroup.internship.models.Benefit;
import com.inthergroup.internship.services.BenefitService;

@Controller
public class BenefitController {
    
    @Autowired
    private BenefitService benefitService;
    
    @RequestMapping("/create-benefit")
    @ResponseBody
    public String createBenefit(String benefitName) {
        Benefit benefit = null;
        try {
            benefit = new Benefit(benefitName);
            benefitService.create(benefit);
        } catch (Exception ex) {
            return "Error creating the benefit: " + ex.toString();
        }
        return "Benefit succesfully created! (id = " + benefit.getId() + ")";
    }
    
    // You must delete benefit only after you deleted it from all
    // users that contained it.
    @RequestMapping("/delete-benefit")
    @ResponseBody
    public String deleteBenefit(long id) {
        try {
            benefitService.deleteById(id);
        } catch (Exception ex) {
            return "Error deleting the benefit by id #" + id + ": " + ex.toString();
        }
        return "Benefit succesfully deleted!";
    }
    
    @RequestMapping("/add-benefit-to-user")
    @ResponseBody
    @Transactional
    public String addBenefitToUser(long userId, long benefitId) {
        try {
            benefitService.addBenefitToUser(userId, benefitId);
        } catch (Exception ex) {
            return "Error adding benefit to user: " + ex.toString();
        }
        return "Succesfully added benefit to user!";
    }
    
    @RequestMapping("/remove-benefit-from-user")
    @ResponseBody
    @Transactional
    public String removeBenefitFromUser(long userId, long benefitId) {
        try {
            benefitService.removeBenefitFromUser(userId, benefitId);
        } catch (Exception ex) {
            return "Error removing benefit from user: " + ex.toString();
        }
        return "Succesfully removed benefit from user!";
    }
    
    @RequestMapping("/add-benefit-to-career-level")
    @ResponseBody
    @Transactional
    public String addBenefitToCareerLevel(long careerLevelId, long benefitId) {
        try {
            benefitService.addBenefitToCareerLevel(careerLevelId, benefitId);
        } catch (Exception ex) {
            return "Error adding benefit to career level: " + ex.toString();
        }
        return "Succesfully added benefit to career level!";
    }
    
    @RequestMapping("/remove-benefit-from-career-level")
    @ResponseBody
    @Transactional
    public String removeBenefitFromCareerLevel(long careerLevelId, long benefitId) {
        try {
            benefitService.removeBenefitFromCareerLevel(careerLevelId, benefitId);
        } catch (Exception ex) {
            return "Error removing benefit from career level: " + ex.toString();
        }
        return "Succesfully removed benefit from career level!";
    }
    
} // class BenefitController
