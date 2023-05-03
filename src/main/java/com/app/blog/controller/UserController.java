package com.app.blog.controller;

import com.app.blog.entity.User;
import com.app.blog.payload.UserDto;
import com.app.blog.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    //    Get user by Id

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserByid(@PathVariable("userId") Long userId){
        System.out.println("USER ID : " + userId);
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }


//    Get all the Users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> listOfUser = userService.getAllUsers();
        return ResponseEntity.ok(listOfUser);
    }




//    Add User
    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto createdUserDto = userService.addUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }


//    update the User

    @PatchMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") Long userId, @RequestBody Map<String, Object> updates){
        UserDto updatedUser = userService.updateUser( userId , updates);
        return ResponseEntity.ok(updatedUser);
    }

//    Delete user by userId

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId){
        userService.deleteuser(userId);
        return ResponseEntity.ok("User Delete Successfully");
    }

}
