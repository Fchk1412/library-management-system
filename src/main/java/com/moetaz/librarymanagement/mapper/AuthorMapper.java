package com.moetaz.librarymanagement.mapper;

import com.moetaz.librarymanagement.dto.AuthorDto;
import com.moetaz.librarymanagement.model.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorMapper {

    public static AuthorDto toDto(Author author){
        return new AuthorDto(author.getId(),
                author.getName(),
                author.getNationality());
    }

    public static List<AuthorDto> toListDto(List<Author> authors){
        List<AuthorDto> authorsDto = new ArrayList<>();
        for (Author author : authors ) {
            authorsDto.add(AuthorMapper.toDto(author));
        }
        return authorsDto;
    }
}
