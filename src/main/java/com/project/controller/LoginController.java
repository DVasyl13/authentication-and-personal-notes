package com.project.controller;

import com.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @GetMapping
    public String login() {
        return "loginpage";
    }

    @PostMapping
    public String verifyUser(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        System.out.println(username + " " + password);
        // Your authentication logic here
        // ...

        // Redirect to another page or return a response
        return "redirect:/login/main";
    }

    @GetMapping("/main")
    private String mainPage() {
        return "mainpage";
    }
}
