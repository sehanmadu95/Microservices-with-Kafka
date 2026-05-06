/**
 * @author SEHAN MADUSHANKA
 * @email sehanmadushanka0714@gmail.com
 * @contact +94776925883
 * @created 5/5/2026
 * <p>
 * Description: UserService class handles ...
 */

package com.smtech.user_service.service;

import com.smtech.user_service.dto.UserDto;
import com.smtech.user_service.entity.User;
import com.smtech.user_service.mapper.UserMapper;
import com.smtech.user_service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto createUser(UserDto userDto) {
        log.info("Creating user: {}", userDto.getEmail());

        User user = userMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);

        log.info("User created with id: {}", savedUser.getId());
        return userMapper.toDto(savedUser);
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        log.info("User found with email: {}", user.getEmail());
        return userMapper.toDto(user);
    }

    public void updateUser(long id, UserDto userDto) {
        log.info("Updating user: {}", userDto.getEmail());
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User with id " + id + " not found"));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setAlerting(userDto.isAlerting());
        user.setEmergencyAlertingThreshold(userDto.getEmergencyAlertingThreshold());

        userRepository.save(user);

    }
}
