package com.project.service;

import com.project.entity.User;
import com.project.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    private User currentUser;

    public boolean isAuthorized() {
        return currentUser != null;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public boolean isExist(String username, String password) {
        var currentUser = userRepository.findUserByUserNameAndPasswordFetchNotes(username,password);
        setCurrentUser(currentUser);
        return Optional.ofNullable(currentUser)
                .isPresent();
    }

    public boolean ifValidSave(String email, String username, String password) {
        if (userRepository.findUsersByEmailOrUserNameFetchNotes(email, username).isEmpty()) {
            var currentUser = userRepository.save(new User(username, password, email));
            setCurrentUser(currentUser);
            return true;
        }
        return false;
    }
}
