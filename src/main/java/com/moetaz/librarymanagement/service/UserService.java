package com.moetaz.librarymanagement.service;

import com.moetaz.librarymanagement.dto.CreateUserRequest;
import com.moetaz.librarymanagement.dto.UpdateUserRequest;
import com.moetaz.librarymanagement.dto.UserDto;
import com.moetaz.librarymanagement.exception.EmailAlreadyExistsException;
import com.moetaz.librarymanagement.exception.UserNotFoundException;
import com.moetaz.librarymanagement.mapper.UserMapper;
import com.moetaz.librarymanagement.model.Role;
import com.moetaz.librarymanagement.model.User;
import com.moetaz.librarymanagement.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private User findUserOrThrow(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public Page<UserDto> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserMapper::toDto);
    }

    public UserDto getUser(Integer id) {
        return UserMapper.toDto(findUserOrThrow(id));
    }

    public UserDto createUser(CreateUserRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException(request.getEmail());
        }
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User user = new User(
                request.getName(),
                request.getEmail(),
                encodedPassword);
        user.setRole(Role.USER);
        userRepository.save(user);
        return UserMapper.toDto(user);
    }

    public UserDto updateUser(Integer id, UpdateUserRequest request) {
        User user = findUserOrThrow(id);
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        userRepository.save(user);
        return UserMapper.toDto(user);
    }

    public UserDto deleteUser(Integer id) {
        User user = findUserOrThrow(id);
        userRepository.delete(user);
        return UserMapper.toDto(user);
    }

    public UserDto updateUserRole(Integer id, Role role) {
        User user = findUserOrThrow(id);
        user.setRole(role);
        userRepository.save(user);
        return UserMapper.toDto(user);
    }

}
