package com.project.service;

import com.project.entity.User;
import com.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean isExist(String username, String password) {
        var currentUser = userRepository.findUserByUserNameAndPassword(username,password);
        setCurrentUser(currentUser);
        return Optional.ofNullable(currentUser)
               .isPresent();
    }

    public boolean ifValidSave(String email, String username, String password) {
        if (userRepository.findUsersByEmailOrUserName(email, username).isEmpty()) {
            userRepository.save(new User(username, password, email));
            return true;
        }
        return false;
    }

    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            return (User) principal;
        }
        return null;
    }

    public void setCurrentUser(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        // Add the appropriate authorities for the user to the list
        // For example:
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
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
