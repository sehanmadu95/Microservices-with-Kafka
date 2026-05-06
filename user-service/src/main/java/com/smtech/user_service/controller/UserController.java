/**
 * @author SEHAN MADUSHANKA
 * @email sehanmadushanka0714@gmail.com
 * @contact +94776925883
 * @created 5/5/2026
 * <p>
 * Description: UserController class handles ...
 */

package com.smtech.user_service.controller;

import com.smtech.user_service.dto.UserDto;
import com.smtech.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto created = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        UserDto userDto=userService.getUserById(id);

        if (userDto==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id, @RequestBody UserDto userDto) {
        try {
            userService.updateUser(id,userDto);
            return new ResponseEntity<>("User updated", HttpStatus.OK);
        } catch (IllegalArgumentException e){
            return  new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
