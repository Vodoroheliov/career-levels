package com.inthergroup.internship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inthergroup.internship.models.Benefit;
import com.inthergroup.internship.models.CareerLevel;
import com.inthergroup.internship.models.Todo;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

  @RequestMapping("/")
  public String index(Model model) {
      List<CareerLevel> careerLevels = new ArrayList<CareerLevel>() {{
          add(new CareerLevel(1, "Internship"));
          add(new CareerLevel(2, "Baby on board"));
      }};
      model.addAttribute("careerLevels", careerLevels);
      
      List<Benefit> benefits = new ArrayList<Benefit>() {{
          add(new Benefit(1, "Lunch 100%"));
          add(new Benefit(2, "Fixed Schedule (9:00-18:00)"));
      }};
      model.addAttribute("benefits", benefits);
      
      List<Todo> todos = new ArrayList<Todo>() {{
          add(new Todo(1, "Prove your are proactive"));
      }};
      model.addAttribute("todos", todos);
    return "index";
  }
}
