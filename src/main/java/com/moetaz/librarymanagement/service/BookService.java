package com.moetaz.librarymanagement.service;
import com.moetaz.librarymanagement.dto.BookDto;
import com.moetaz.librarymanagement.dto.CreateBookRequest;
import com.moetaz.librarymanagement.exception.AuthorNotFoundException;
import com.moetaz.librarymanagement.exception.BookNotFoundException;
import com.moetaz.librarymanagement.mapper.BookMapper;
import com.moetaz.librarymanagement.model.Author;
import com.moetaz.librarymanagement.repository.AuthorRepository;
import com.moetaz.librarymanagement.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import com.moetaz.librarymanagement.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository,AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookDto> getBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> booksDto = new ArrayList<>();
        for (Book book : books) {
            booksDto.add(BookMapper.toDto(book));
        }
        return booksDto;
    }

    public Book getBook(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id)
                );
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book deleteBook(Integer id) {
        Book book = getBook(id);
        bookRepository.delete(book);
        return book;
    }

    public Book updateBook(Integer id, Book updatedBook) {
        Book book = getBook(id);
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        bookRepository.save(book);
        return book;
    }

    /*public List<Book> getBooksByAuthorName(String name) {
        return bookRepository.findByAuthorName(name);
    }*/
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
    public List<Book> getBooksByAuthorSorted(String name,Sort sort){
        return bookRepository.findByAuthorName(name,sort);
    }

    public BookDto createBook( CreateBookRequest request){
        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(request.getAuthorId()));

        Book book = new Book(request.getTitle(), author);
        bookRepository.save(book);
        return BookMapper.toDto(book);
    }
}

