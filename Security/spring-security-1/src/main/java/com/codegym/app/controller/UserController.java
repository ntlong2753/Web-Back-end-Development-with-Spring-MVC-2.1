package com.codegym.app.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    @GetMapping("/user")
    public String user(Model model, Principal principal) {
        System.out.println(principal.getName());
        return "user";
    }
    @GetMapping("/admin")
    public String login(Model model) {
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return "admin";
    }
}
