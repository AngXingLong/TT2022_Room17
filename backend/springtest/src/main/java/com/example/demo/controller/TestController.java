package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.techtrek.TechtrekClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    UserService userService;

    @Autowired
    TechtrekClient techtrekClient;

    @GetMapping("/test")
    public User test1() {
        return techtrekClient.insertUser();
    }


}