package com.project.controller;

import com.project.service.NoteService;
import com.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class NotePageController {
    private final UserService userService;
    private final NoteService noteService;

    @GetMapping
    private String mainPage(Model model) {
        if (!userService.isAuthorized()) {
            return "redirect:login";
        }
        model.addAttribute("notes", userService.getCurrentUser().getNotes());
        return "main";
    }

    @PostMapping
    public String saveNote(@RequestParam("text") String text) {
        noteService.save(text);
        return "redirect:main";
    }
}
