package com.app.blog.service.userService;

import com.app.blog.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface UserService {
//    Get all Users
    List<UserDto> getAllUsers();

//    Get the user by Id
    UserDto getUserById(Long userId);
//    Add the User
    UserDto addUser(UserDto userDto);

//    Update the User
    UserDto updateUser(Long userId, Map<String,Object> updates);

//    Delete User
    void deleteuser(Long userId);

}
