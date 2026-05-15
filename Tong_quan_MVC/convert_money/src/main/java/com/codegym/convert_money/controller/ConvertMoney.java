package com.codegym.convert_money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertMoney {
    @GetMapping("/")
    public String convert() {
        return "index";
    }

    @PostMapping("/result")
    public String convert(@RequestParam("type") String type,
                          @RequestParam("rate") double rate,
                          @RequestParam("amount") double amount,
                          Model model) {
        double result;
        String message;

        if ("usdToVnd".equals(type)) {
            result = amount * rate;
            message = amount + " USD = " + result + " VND";
        } else {
            result = amount / rate;
            message = amount + " VND = " + result + " USD";
        }

        model.addAttribute("resultMessage", message);
        return "result";
    }
}
