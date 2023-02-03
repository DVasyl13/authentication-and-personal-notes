package com.project.service;

import com.project.entity.User;
import com.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userService;

    public User getUserById(Long id) {
        return userService.findById(id)
                .orElseThrow();
    }

    public List<User> getAllUsers() {
        return userService.findAll();
    }

    public void removeUserById(Long id) {
        userService.deleteById(id);
    }

}
