package com.project.repository;

import com.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserNameAndPassword(String userName, String password);

    List<User> findUsersByEmailOrUserName(String email, String userName);
}
