package com.moetaz.librarymanagement.service;

import com.moetaz.librarymanagement.dto.CreateUserRequest;
import com.moetaz.librarymanagement.dto.UpdateUserRequest;
import com.moetaz.librarymanagement.dto.UserDto;
import com.moetaz.librarymanagement.exception.UserNotFoundException;
import com.moetaz.librarymanagement.mapper.UserMapper;
import com.moetaz.librarymanagement.model.User;
import com.moetaz.librarymanagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public  UserService(UserRepository userRepository, BookService bookService){
        this.userRepository = userRepository;
    }


    private User findUserOrThrow(Integer id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }


    public List<UserDto> getAllUsers(){
        return UserMapper.toListDto(userRepository.findAll());
    }

    public UserDto getUser(Integer id){
        return UserMapper.toDto(findUserOrThrow(id));
    }

    public UserDto createUser(CreateUserRequest request){

        User user = new User(
                request.getName(),
                request.getEmail(),
                request.getPassword());
        userRepository.save(user);
        return UserMapper.toDto(user);
    }

    public UserDto updateUser(Integer id, UpdateUserRequest request){
        User user = findUserOrThrow(id);
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        userRepository.save(user);
        return UserMapper.toDto(user);
    }

    public UserDto deleteUser(Integer id){
        User user = findUserOrThrow(id);
        userRepository.delete(user);
        return UserMapper.toDto(user);
    }

}
