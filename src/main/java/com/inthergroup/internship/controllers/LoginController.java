package com.inthergroup.internship.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inthergroup.internship.forms.LoginForm;

@Controller
public class LoginController {


    @RequestMapping("/todos/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "todos/login";
    }

    @RequestMapping(value = "/todos/login",
            method = RequestMethod.POST)
    public String showLoginForm(
            @Valid @ModelAttribute("loginForm")LoginForm loginForm,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "todos/login";
        }

//        if (! loginService.authentice(loginForm.getUsername(),
//                loginForm.getPassword())) {
//            notificationService.addErrorMessage("Invalid login");
//            return "users/login";
//        }

        // Login successful
        return "redirect:/";
    }
}
