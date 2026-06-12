package com.codegym.registervalid.controller;

import com.codegym.registervalid.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/validate")
    public String checkValidation(@Validated @ModelAttribute("user") User user,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        return "result";
    }
}
