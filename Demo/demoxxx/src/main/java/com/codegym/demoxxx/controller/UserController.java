package com.codegym.demoxxx.controller;

import com.codegym.demoxxx.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {
    public List<User> listUser;

    public UserController() {
        listUser = new ArrayList<>();
        listUser.add(new User(1, "Jayce"));
        listUser.add(new User(2, "Xinzhao"));
        listUser.add(new User(3, "Yasuo"));
        listUser.add(new User(4, "Jinx"));
        listUser.add(new User(5, "Malphite"));
    }

    @GetMapping("")
    public String listUsers(Model model) {
        model.addAttribute("listUsers", listUser);
        return "users/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        System.out.println(id);
        return "redirect:/users";
    }
}
