package com.project.repository;

import com.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select distinct u from User u left join fetch u.notes where u.userName=?1 and u.password=?2")
    User findUserByUserNameAndPasswordFetchNotes(String userName, String password);

    @Query("select distinct u from User u left join fetch u.notes where u.email=?1 and u.userName=?2")
    List<User> findUsersByEmailOrUserNameFetchNotes(String email, String userName);
}
