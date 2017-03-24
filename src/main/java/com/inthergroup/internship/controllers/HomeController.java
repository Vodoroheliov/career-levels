package com.inthergroup.internship.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public String index(Model model) {

        // List<CareerLevel> careerLevels = new ArrayList<CareerLevel>() {{
        // add(new CareerLevel(1, "Internship"));
        // add(new CareerLevel(2, "Baby on board"));
        // }};
        // model.addAttribute("careerLevels", careerLevels);
        //
        // List<Benefit> benefits = new ArrayList<Benefit>() {{
        // add(new Benefit(1, "Lunch 100%"));
        // add(new Benefit(2, "Fixed Schedule (9:00-18:00)"));
        // }};
        // model.addAttribute("benefits", benefits);
        //
        // List<Todo> todos = new ArrayList<Todo>() {{
        // add(new Todo(1, "Prove your are proactive"));
        // }};
        // model.addAttribute("todos", todos);

        List<CareerLevel> careerLevels = careerLevelService.findAll();
        model.addAttribute("careerLevels", careerLevels);

        List<Benefit> benefits = benefitService.findAll();
        model.addAttribute("benefits", benefits);

        List<Todo> todos = todoService.findAll();
        model.addAttribute("todos", todos);

//        return "index";
        return careerLevels.toString();
    }
}
