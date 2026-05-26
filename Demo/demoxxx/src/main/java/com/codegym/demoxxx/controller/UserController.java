package com.codegym.demoxxx.controller;

import com.codegym.demoxxx.entities.User;
import com.codegym.demoxxx.request.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        // 1. Tìm user có id trùng với id truyền vào
        User userToDelete = null;
        for (User user : listUser) {
            if (user.getId() == id) {
                userToDelete = user;
                break; // Tìm thấy rồi thì dừng vòng lặp luôn
            }
        }
        // 2. Nếu tìm thấy thì xóa khỏi danh sách
        if (userToDelete != null) {
            listUser.remove(userToDelete);
        }
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String showFormAdd() {
        return "users/add";
    }

    @PostMapping("/add")
    public String saveAdd(@ModelAttribute("userRequest") UserRequest userRequest) {
        System.out.println(userRequest.getName());
        return "redirect:/users";
    }
}
