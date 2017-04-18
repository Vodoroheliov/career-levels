package com.inthergroup.internship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GeneralErrorController {
    /**
     * Shows general error page.
     * @param msg Message to show in error page.
     * @return
     */
    @RequestMapping("/general-error")
    public String handleError(@RequestParam("msg") String msg, Model model) {
        model.addAttribute("message", msg);
        return "/errors/error";
    }
}
