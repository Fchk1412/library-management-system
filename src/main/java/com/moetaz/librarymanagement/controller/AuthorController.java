package com.moetaz.librarymanagement.controller;


import com.moetaz.librarymanagement.model.Author;
import com.moetaz.librarymanagement.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }
    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable Integer id){
        return authorService.getAuthor(id);
    }
    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }
    @DeleteMapping("/authors/{id}")
    public Author deleteAuthor(@PathVariable Integer id){
        return authorService.deleteAuthor(id);
    }
    @PutMapping("/authors/{id}")
    public Author updateAuthor(@PathVariable Integer id, @RequestBody Author author){
        return authorService.updateAuthor(id,author);
    }
}
