package com.app.blog.service.registerService;

import com.app.blog.entity.User;
import com.app.blog.record.RegisterRequest;

public interface RegisterUserService {
    User registerUser(RegisterRequest registerRequest);
}
