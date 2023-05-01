package com.app.blog.service.registerService;

import com.app.blog.entity.User;
import com.app.blog.exception.UserAlreadyExistsException;
import com.app.blog.record.RegisterRequest;
import com.app.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(RegisterRequest registerRequest) {
        Optional<User> existingUser = userRepository.findByEmail(registerRequest.email());
        if(existingUser.isPresent()){
            throw new UserAlreadyExistsException("User with email + "+registerRequest.email()+"already exists");
        }

        User newUser = new User();
        newUser.setEmail(registerRequest.email());
        newUser.setFirstName(registerRequest.firstName());
        newUser.setLastName(registerRequest.lastName());
        newUser.setRole(registerRequest.role());
        newUser.setPassword(registerRequest.password());

        User savedUser = userRepository.save(newUser);
        return savedUser;

    }
}
