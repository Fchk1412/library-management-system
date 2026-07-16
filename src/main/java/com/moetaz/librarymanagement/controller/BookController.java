package com.moetaz.librarymanagement.controller;

import com.moetaz.librarymanagement.model.Book;
import com.moetaz.librarymanagement.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public Book getBook() {
        return bookService.getBook();
    }
}