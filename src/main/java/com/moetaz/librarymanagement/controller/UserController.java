package com.moetaz.librarymanagement.controller;

import com.moetaz.librarymanagement.dto.CreateUserRequest;
import com.moetaz.librarymanagement.dto.UpdateUserRequest;
import com.moetaz.librarymanagement.dto.UserDto;
import com.moetaz.librarymanagement.model.Role;
import com.moetaz.librarymanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public Page<UserDto> getUsers(@PageableDefault(size = 10) Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    // Public — anyone can register
    @PostMapping("/users")
    public UserDto createUser(@RequestBody @Valid CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @PutMapping("/users/{id}")
    public UserDto updateUser(@PathVariable Integer id, @RequestBody @Valid UpdateUserRequest request) {
        return userService.updateUser(id, request);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/{id}")
    public UserDto deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/users/{id}/role")
    public UserDto updateUserRole(@PathVariable Integer id, @RequestParam Role role) {
        return userService.updateUserRole(id, role);
    }
}
