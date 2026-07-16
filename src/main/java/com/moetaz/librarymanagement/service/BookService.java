package com.moetaz.librarymanagement.service;

import com.moetaz.librarymanagement.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    public Book getBook() {
        return new Book(
                1,
                "His las bow",
                "Conan Doyle"
        );
    }
}