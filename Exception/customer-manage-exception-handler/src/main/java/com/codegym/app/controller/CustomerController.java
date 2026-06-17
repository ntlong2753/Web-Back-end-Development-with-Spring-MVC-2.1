package com.codegym.app.controller;

import com.codegym.app.exception.DuplicateEmailException;
import com.codegym.app.model.Customer;
import com.codegym.app.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String index(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String save(Customer customer) throws DuplicateEmailException {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm (@PathVariable("id") Long id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "update";
    }

    @PostMapping("/update")
    public String update(Customer customer) throws DuplicateEmailException {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirect) {
        customerService.remove(id);
        return "redirect:/customers";
    }

    @GetMapping("view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public String showInputNotAcceptable(Model model) {
        return "inputs-not-acceptable";
    }
}
