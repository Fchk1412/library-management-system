package com.moetaz.librarymanagement.controller;

import com.moetaz.librarymanagement.model.Book;
import com.moetaz.librarymanagement.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Integer id){
        return  bookService.getBook(id);
    }
    @GetMapping("/books/name/{name}")
    public List<Book> getBooksByAuthorName(@PathVariable String name){
        return bookService.getBooksByAuthorName(name);
    }

    @GetMapping("/books/search/{title}")
    public List<Book> getBooksByTitle(@PathVariable String title){
        return bookService.getBooksByTitle(title);
    }
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
    @DeleteMapping("/books/{id}")
    public Book deleteBook(@PathVariable Integer id){
           return bookService.deleteBook(id);
    }
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Integer id,@RequestBody Book book){
        return bookService.updateBook(id,book);

    }
}