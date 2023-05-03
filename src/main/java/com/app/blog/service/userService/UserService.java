package com.app.blog.service.userService;

import com.app.blog.entity.User;
import com.app.blog.payload.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
//    Get all Users
    List<UserDto> getAllUsers();

//    Get the user by Id
    UserDto getUserById(Long userId);
//    Add the User
    UserDto addUser(UserDto userDto);

//    Update the User
    UserDto updateUser(UserDto userDto);

//    Delete User
    void deleteuser(Long userId);

}
