package com.app.blog.service.userService;

import com.app.blog.entity.User;
import com.app.blog.exception.ResourceNotFoundException;
import com.app.blog.exception.ResourceAlreadyExistsException;
import com.app.blog.payload.UserDto;
import com.app.blog.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();

        List <UserDto>  userDtos = users.stream().map(user->{
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            return userDto;
        }).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User fetchedUser = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found"));
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(fetchedUser, userDto);
        return userDto;
    }

    @Override
    public UserDto addUser(UserDto userDto) {

        Optional<User> fetchedUser = userRepository.findByEmail(userDto.getEmail());

        if(fetchedUser.isPresent()){
            throw new ResourceAlreadyExistsException("User already exists");
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        User storeduser = userRepository.save(user);

        UserDto userDtoResponse = new UserDto();
        BeanUtils.copyProperties(storeduser, userDtoResponse);

        return userDtoResponse;
    }

    @Override
    public UserDto updateUser(Long userId, Map<String, Object> updates) {
        User fetchedUser = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
        updates.forEach((key,value)->{
            Field filed = ReflectionUtils.findField(User.class, key);
            if(filed != null && value != "" && value!= null){
                filed.setAccessible(true);
                ReflectionUtils.setField(filed,fetchedUser,value);
            }
        });
        User updatedUser = userRepository.save(fetchedUser);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(updatedUser, userDto);
        return userDto;
    }

    @Override
    public void deleteuser(Long userId) {
        User fetchedUser = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        userRepository.delete(fetchedUser);
    }
}
