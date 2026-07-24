package com.moetaz.librarymanagement.controller;

import com.moetaz.librarymanagement.dto.AuthorDto;
import com.moetaz.librarymanagement.dto.CreateAuthorRequest;
import com.moetaz.librarymanagement.dto.UpdateAuthorRequest;
import com.moetaz.librarymanagement.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<AuthorDto> getAuthors() {
        return authorService.findAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public AuthorDto getAuthor(@PathVariable Integer id) {
        return authorService.getAuthor(id);
    }

    @GetMapping("/authors/name/{name}")
    public AuthorDto getAuthorByName(@PathVariable String name) {
        return authorService.getAuthorByName(name);
    }

    @PostMapping("/authors")
    public AuthorDto createAuthor(@RequestBody @Valid CreateAuthorRequest request) {
        return authorService.createAuthor(request);
    }

    @DeleteMapping("/authors/{id}")
    public AuthorDto deleteAuthor(@PathVariable Integer id) {
        return authorService.deleteAuthor(id);
    }

    @PutMapping("/authors/{id}")
    public AuthorDto updateAuthor(@PathVariable Integer id, @RequestBody @Valid UpdateAuthorRequest request) {
        return authorService.updateAuthor(id, request);
    }
}