package com.moetaz.librarymanagement.service;


import com.moetaz.librarymanagement.dto.AuthorDto;
import com.moetaz.librarymanagement.dto.CreateAuthorRequest;
import com.moetaz.librarymanagement.dto.UpdateAuthorRequest;
import com.moetaz.librarymanagement.exception.AuthorNotFoundException;
import com.moetaz.librarymanagement.mapper.AuthorMapper;
import com.moetaz.librarymanagement.model.Author;
import com.moetaz.librarymanagement.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // =========================
// Private helper methods
// =========================


    private Author findAuthorOrThrow(Integer id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    public List<AuthorDto> findAllAuthors() {
        return AuthorMapper.toListDto(authorRepository.findAll());
    }

    public AuthorDto getAuthor(Integer id) {
        return AuthorMapper.toDto(findAuthorOrThrow(id));
    }

    public AuthorDto createAuthor(CreateAuthorRequest request) {
        Author author = new Author(
                request.getName(),
                request.getNationality()
        );
        authorRepository.save(author);
        return AuthorMapper.toDto(author);
    }

    public AuthorDto deleteAuthor(Integer id) {
        Author author = findAuthorOrThrow(id);
        authorRepository.delete(author);
        return AuthorMapper.toDto(author);
    }

    public AuthorDto updateAuthor(Integer id, UpdateAuthorRequest request) {
        Author author = findAuthorOrThrow(id);
        author.setName(request.getName());
        author.setNationality(request.getNationality());
        authorRepository.save(author);
        return AuthorMapper.toDto(author);
    }

    public AuthorDto getAuthorByName(String name) {
        return AuthorMapper.toDto(authorRepository.findByName(name)
                .orElseThrow(() -> new AuthorNotFoundException(name)));
    }
}
