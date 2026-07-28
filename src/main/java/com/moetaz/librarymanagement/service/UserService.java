package com.moetaz.librarymanagement.service;

import com.moetaz.librarymanagement.dto.UserDto;
import com.moetaz.librarymanagement.exception.UserNotFoundExeption;
import com.moetaz.librarymanagement.mapper.UserMapper;
import com.moetaz.librarymanagement.model.User;
import com.moetaz.librarymanagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public  UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    private User findUserOrThrow(Integer id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundExeption(id));
    }


    public List<UserDto> getAllUsers(){
        return UserMapper.toListDto(userRepository.findAll());
    }

    public UserDto getUser(Integer id){
        return UserMapper.toDto(findUserOrThrow(id));
    }


}
