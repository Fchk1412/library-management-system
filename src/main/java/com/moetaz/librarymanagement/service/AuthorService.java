package com.moetaz.librarymanagement.service;


import com.moetaz.librarymanagement.exception.AuthorNotFoundException;
import com.moetaz.librarymanagement.model.Author;
import com.moetaz.librarymanagement.repository.AuthorRepository;
import com.moetaz.librarymanagement.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }
    public Author getAuthor(Integer id){
        return authorRepository.findById(id)
                .orElseThrow(()-> new AuthorNotFoundException(id));
    }
    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }
    public Author deleteAuthor(Integer id){
        Author author = getAuthor(id);
        authorRepository.delete(author);
        return author;
    }
    public Author updateAuthor(Integer id, Author updatedauthor){
        Author author = getAuthor(id);
        author.setName(updatedauthor.getName());
        author.setNationality(updatedauthor.getNationality());
        authorRepository.save(author);
        return author;
    }
    public Optional<Author> getAuthorByName(String name){
        return authorRepository.findByName(name);
    }
}
