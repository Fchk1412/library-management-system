package com.moetaz.librarymanagement.controller;
import com.moetaz.librarymanagement.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/book")
    public Book book() {
        return new Book(
                1,
                "His last bow",
                "Conan doyle"
        );
    }

}