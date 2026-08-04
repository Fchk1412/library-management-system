package com.moetaz.librarymanagement.controller;

import com.moetaz.librarymanagement.dto.BookDto;
import com.moetaz.librarymanagement.dto.BorrowBookRequest;
import com.moetaz.librarymanagement.dto.CreateBookRequest;
import com.moetaz.librarymanagement.dto.UpdateBookRequest;
import com.moetaz.librarymanagement.service.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public Page<BookDto> getBooks(@PageableDefault(size = 10) Pageable pageable) {
        return bookService.findAllBooks(pageable);
    }

    @GetMapping("/books/{id}")
    public BookDto getBook(@PathVariable Integer id) {
        return bookService.getBook(id);
    }

    @GetMapping("/books/search")
    public Page<BookDto> getBooksByTitle(
            @RequestParam String title,
            @PageableDefault(size = 10) Pageable pageable) {

        return bookService.getBooksByTitle(title, pageable);
    }
    @GetMapping("/books/author/{name}")
    public List<BookDto> getBooksByAuthorSorted(@PathVariable String name, Sort sort) {
        return bookService.getBooksByAuthorSorted(name, sort);
    }

    @PostMapping("/books")
    public BookDto createBook(@RequestBody @Valid CreateBookRequest request) {
        return bookService.createBook(request);
    }

    @PostMapping("/books/{bookId}/borrow")
    public BookDto borrowBook(@PathVariable Integer bookId, @RequestBody @Valid BorrowBookRequest request) {
        return bookService.borrowBook(bookId, request);
    }

    @PutMapping("/books/{id}")
    public BookDto updateBook(@PathVariable Integer id, @RequestBody @Valid UpdateBookRequest request) {
        return bookService.updateBook(id, request);

    }

    @PutMapping("/books/{id}/return")
    public BookDto returnBook(@PathVariable Integer id) {
        return bookService.returnBook(id);
    }

    @DeleteMapping("/books/{id}")
    public BookDto deleteBook(@PathVariable Integer id) {
        return bookService.deleteBook(id);
    }

}