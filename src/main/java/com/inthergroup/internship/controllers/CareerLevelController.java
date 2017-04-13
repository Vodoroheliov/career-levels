package com.inthergroup.internship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inthergroup.internship.models.CareerLevel;
import com.inthergroup.internship.services.CareerLevelService;

@Controller
public class CareerLevelController {
    
    @Autowired
    private CareerLevelService careerLevelService;
    
    @RequestMapping("/create-career-level")
    @ResponseBody
    public String createCareerLevel(String levelName) {
        CareerLevel careerLevel = null;
        try {
            careerLevel = new CareerLevel(levelName);
            careerLevelService.create(careerLevel);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error creating the Career Level: " + ex.toString();
        }
        return "Career Level succesfully created! (id = " + careerLevel.getId() + ")";
    }
    
    @RequestMapping("/update-user-career-level")
    @ResponseBody
    public String updateUserCareerLevel(long userId, long careerLevelId) {
        try {
            careerLevelService.updateUserCareerLevel(userId, careerLevelId);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error updating user's career level: " + ex.toString();
        }
        return "Succesfully updated user's career level!";
    }
    
    // You must delete career level only after you deleted it from all
    // users that contained it.
    @RequestMapping("/delete-career-level")
    @ResponseBody
    public String deleteCareerLevel(long id) {
        try {
            careerLevelService.deleteById(id);
        } catch (Exception ex) {
            return "redirect:/general-error?msg=" +
                    "Error deleting the career level by id #" + id + ": "
                    + ex.toString();
        }
        return "Career level succesfully deleted!";
    }
    
} // class CareerLevelController
