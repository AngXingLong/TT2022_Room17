package com.example.demo.respository;

import com.example.demo.model.User;
import com.example.demo.model.UserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query("select u from User u where username = :username")
    Optional<UserView> getByUserNameUserView(String username);

    @Query("select u from User u where id = :id")
    Optional<User> getById(Long id);



}