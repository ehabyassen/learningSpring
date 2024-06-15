package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm() {
        return "helloWorld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloWorld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String processForm(HttpServletRequest request, Model model) {
        StringBuilder message = new StringBuilder("Yo! ")
                .append(request.getParameter("firstName"))
                .append(" ")
                .append(request.getParameter("lastName"));
        model.addAttribute("message", message);
        return "helloWorld";
    }

    @PostMapping("/processFormVersionThree")
    public String processForm(@RequestParam String firstName,
                              @RequestParam String lastName, Model model) {
        StringBuilder message = new StringBuilder("Hey My Friend! ")
                .append(firstName)
                .append(" ")
                .append(lastName);
        model.addAttribute("message", message);
        return "helloWorld";
    }
}
