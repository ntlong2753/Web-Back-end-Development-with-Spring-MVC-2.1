package com.codegym.app.controller;

import com.codegym.app.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // Đánh dấu đây là 1 controller
@SessionAttributes("user") // Lưu session với key "user"
public class LoginController {

    @ModelAttribute("user") // Tạo ra 1 model user
    public User setupUser() {
        return new User();
    }

    @GetMapping("/login") // Map mapping với url /login
    public String showForm(@CookieValue(value = "rememberEmail", defaultValue = "") String rememberedEmail,
            Model model) {
        model.addAttribute("emailRemembered", rememberedEmail);
        return "login";
    }

    @PostMapping("/doLogin") // Map mapping với url /doLogin
    public String doLogin(@ModelAttribute("user") User user, // Lấy user từ model
            Model model, // Model để thêm dữ liệu vào view
            HttpServletResponse response) { // HttpServletResponse để thêm cookie

        if ("admin@gmail.com".equals(user.getEmail()) && "123456".equals(user.getPassword())) {
            Cookie cookie = new Cookie("rememberEmail", user.getEmail());
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            model.addAttribute("message", "✅ Login successful!");
        } else {
            model.addAttribute("message", "❌ Invalid credentials. Try again.");
            user.setEmail("");
        }

        return "login";
    }
}
