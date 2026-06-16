package com.codegym.demoexception.controller;

import com.codegym.demoexception.model.Customer;
import com.codegym.demoexception.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public String showList(Model model) {
        try {
            List<Customer> customers = customerService.findAll();
            model.addAttribute("customers", customers);
            return "/customer/list";
        } catch (Exception e) {
            return "redirect:/customers";
        }
    }

    @GetMapping("/{id}")
    public String showInformation(@PathVariable("id") Long id, Model model) {
        try {
            List<Customer> customers = customerService.findAll();
            model.addAttribute("customers", customers);
            return "/customer/info";
        } catch (Exception e) {
            return "redirect:/customers";
        }
    }
}
