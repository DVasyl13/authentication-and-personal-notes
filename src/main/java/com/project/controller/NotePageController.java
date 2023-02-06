package com.project.controller;

import com.project.entity.User;
import com.project.service.NoteService;
import com.project.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class NotePageController {
    private final NoteService noteService;
    private final UserService userService;

    @GetMapping
    public String load(Model model) {
        if (!userService.isAuthorized()) {
            return "redirect:login";
        }
        model.addAttribute("notes", userService.getCurrentUser().getNotes());
        return "main";
    }

    @Transactional
    @PostMapping
    public String saveNote(@RequestParam("text") String text) {
        noteService.save(userService.getCurrentUser(), text);
        return "redirect:main";
    }
}
