package com.app.blog.controller;

import com.app.blog.entity.User;
import com.app.blog.record.RegisterRequest;
import com.app.blog.service.registerService.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationUserController {

    @Autowired
    RegisterUserService registerService;

    @PostMapping
    public User registerUser(RegisterRequest registerRequest){
        return registerService.registerUser(registerRequest);
    }
}

