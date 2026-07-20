package com.moetaz.librarymanagement.mapper;

import com.moetaz.librarymanagement.dto.BookDto;
import com.moetaz.librarymanagement.dto.CreateBookRequest;
import com.moetaz.librarymanagement.model.Book;
import com.moetaz.librarymanagement.service.AuthorService;
import org.springframework.web.bind.annotation.RestController;



public class BookMapper {



    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(),
                book.getTitle(),
                book.getAuthor().getName());
    }

}
