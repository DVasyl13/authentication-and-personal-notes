package com.project.controller;

import com.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class NotePageController {
    private final UserService userService;

    @GetMapping("/main")
    private String mainPage() {
        System.out.println(userService.getCurrentUser());
        return "main";
    }


}
