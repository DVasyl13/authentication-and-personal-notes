package com.project.controller;

import com.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {
    private final UserService userService;

    @PostMapping
    public String verify(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestParam("password") String password) {
        if(userService.ifValidSave(email, username, password)) {
            return "redirect:/main";
        }
        return "redirect:/signup";
    }

    @GetMapping
    public String signup() {
        return "signup";
    }
}
