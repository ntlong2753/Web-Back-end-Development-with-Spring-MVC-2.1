package com.codegym.demoxxx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class LoginController {
    @GetMapping("/login")
    public String loginForm(@RequestParam(value = "error", required = false) String error, Model model){
        if(error != null) {
            model.addAttribute("errorMessage", "Accout khong ton tai");
        }
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        if(username.equals("admin@gmail.com") && password.equals("12345678")) {
            return "redirect:/admin";
        }
        return "redirect: auth/login?error=true";
    }
}
