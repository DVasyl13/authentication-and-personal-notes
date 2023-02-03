package com.project.controller;

import com.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {
    private final UserRepository userRepository;

    @PostMapping
    public String verify() {
        // something

        return "redirect:/signup";
    }

    @GetMapping
    public String signup() {
        return "signuppage";
    }
}
