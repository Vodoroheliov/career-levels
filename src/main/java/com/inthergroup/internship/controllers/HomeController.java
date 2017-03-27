package com.inthergroup.internship.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inthergroup.internship.models.CareerLevel;
import com.inthergroup.internship.services.BenefitService;
import com.inthergroup.internship.services.CareerLevelService;
import com.inthergroup.internship.services.TodoService;

@Controller
public class HomeController {

    @Autowired
    private CareerLevelService careerLevelService;
    
    @Autowired
    private BenefitService benefitService;
    
    @Autowired
    private TodoService todoService;

    @RequestMapping("/")
    public String index(Model model) {

        // List all careerl levels
        List<CareerLevel> careerLevels = careerLevelService.findAllByOrderByIdAsc();
        model.addAttribute("careerLevels", careerLevels);
        

        // For each career level list its benefits
        List<List<String>> benefits = new ArrayList<List<String>>();
        for (long i = 1; i <= careerLevels.size(); i++) {
            List<String> benefitsFromLevel = benefitService.findBenefitsFromLevel(i);
            benefits.add(benefitsFromLevel);
        }
        model.addAttribute("benefits", benefits);

        // For each career level list its todos
        List<List<String>> todos = new ArrayList<List<String>>();
        for (long i = 1; i <= careerLevels.size(); i++) {
            List<String> todosFromLevel = todoService.findTodosFromLevel(i);
            todos.add(todosFromLevel);
        }
        model.addAttribute("todos", todos);

        return "index";
    }
}
