package com.project.controller;

import com.project.entity.User;
import com.project.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @GetMapping
    public String login() {
        return "login";
    }

    @PostMapping
    public String verifyUser(@RequestParam("username") String username,
                             @RequestParam("password") String password) {
        if (userService.isExist(username, password)) {
            return "redirect:/main";
        }
        return "redirect:/login";
    }
}
