package com.app.blog.controller;

import com.app.blog.entity.User;
import com.app.blog.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
