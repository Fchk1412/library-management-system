package com.moetaz.librarymanagement.mapper;


import com.moetaz.librarymanagement.dto.UserDto;
import com.moetaz.librarymanagement.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserDto toDto(User user) {
        return new UserDto(user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }

    public static List<UserDto> toListDto(List<User> users){
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : users){
            usersDto.add(toDto(user));
        }
        return usersDto;
    }
}
