package com.codegym.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping("/car?/s?o?/info1")
    public String info1(Model model) {
        model.addAttribute("message","Infor1");
        return "/index";
    }

    @RequestMapping("/c*/s*d/info2")
    public ModelAndView info2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        modelAndView.addObject("message","Infor2");
        return modelAndView;
    }

    @RequestMapping("/card/**")
    public ModelAndView info3() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        modelAndView.addObject("message","Infor3");
        return modelAndView;
    }
}
