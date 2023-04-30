package com.app.blog.service.userService;

import com.app.blog.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
}
