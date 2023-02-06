package com.project.controller.api;

import com.project.entity.User;
import com.project.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserRepository userRepository;

    @GetMapping()
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public HttpServletResponse removeById(@PathVariable Long id, HttpServletResponse response) {
        userRepository.deleteById(id);
       return response;
    }
}
