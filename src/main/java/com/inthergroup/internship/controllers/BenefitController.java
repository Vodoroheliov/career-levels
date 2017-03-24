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
} // class BenefitController
