package com.project.service;

import com.project.entity.User;
import com.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private User currentUser;

    public boolean isAuthorized() {
        return currentUser != null;
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

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void removeUserById(Long id) {
        userRepository.deleteById(id);
    }

}
