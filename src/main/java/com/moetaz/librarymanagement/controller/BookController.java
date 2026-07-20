package com.moetaz.librarymanagement.controller;

import com.moetaz.librarymanagement.dto.BookDto;
import com.moetaz.librarymanagement.dto.CreateBookRequest;
import com.moetaz.librarymanagement.model.Book;
import com.moetaz.librarymanagement.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<BookDto> getBooks() {
        return bookService.getBooks();
    }


    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Integer id){
        return  bookService.getBook(id);
    }
    /*@GetMapping("/books/author/name/{name}")
    public List<Book> getBooksByAuthorName(@PathVariable String name){
        return bookService.getBooksByAuthorName(name);
    }
     */

    @GetMapping("/books/search/{title}")
    public List<Book> getBooksByTitle(@PathVariable String title){
        return bookService.getBooksByTitle(title);
    }
    @GetMapping("/books/author/{name}")
    public List<Book>  getBooksByAuthorSorted(@PathVariable String name, Sort sort){
        return bookService.getBooksByAuthorSorted(name,sort);
    }

    @PostMapping("/books")
    public BookDto createBook(@RequestBody CreateBookRequest request){
        return bookService.createBook(request);
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