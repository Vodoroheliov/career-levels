package com.inthergroup.internship.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inthergroup.internship.models.Benefit;
import com.inthergroup.internship.models.CareerLevel;
import com.inthergroup.internship.models.Todo;
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

        List<CareerLevel> careerLevels = careerLevelService.findAllByOrderByIdAsc();
        model.addAttribute("careerLevels", careerLevels);

        List<Benefit> benefits = benefitService.findAll();
        model.addAttribute("benefits", benefits);

        List<Todo> todos = todoService.findAll();
        model.addAttribute("todos", todos);

        return "index";
    }
}
