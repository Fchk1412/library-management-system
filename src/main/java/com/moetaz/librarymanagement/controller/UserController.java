package com.moetaz.librarymanagement.controller;


import com.moetaz.librarymanagement.dto.CreateUserRequest;
import com.moetaz.librarymanagement.dto.UpdateUserRequest;
import com.moetaz.librarymanagement.dto.UserDto;
import com.moetaz.librarymanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public UserDto createUser(@RequestBody @Valid CreateUserRequest request){
        return userService.createUser(request);
    }

    @PutMapping("/users/{id}")
    public UserDto updateUser(@PathVariable Integer id, @RequestBody @Valid UpdateUserRequest request){
        return userService.updateUser(id,request);
    }

    @DeleteMapping("/users/{id}")
    public UserDto deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
