package com.moetaz.librarymanagement.mapper;

import com.moetaz.librarymanagement.dto.BookDto;
import com.moetaz.librarymanagement.model.Book;

import java.util.ArrayList;
import java.util.List;


public class BookMapper {



    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(),
                book.getTitle(),
                book.getAuthor().getName());
    }

    public static List<BookDto> toListDto(List<Book> books){
    List<BookDto> booksDto = new ArrayList<>();
        for (Book book : books) {
        booksDto.add(BookMapper.toDto(book));
        }
        return booksDto;

}
}
