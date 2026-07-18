package com.moetaz.librarymanagement.service;
import com.moetaz.librarymanagement.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.moetaz.librarymanagement.model.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Book not found"
                ));
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

    public List<Book> getBooksByAuthorName(String name) {
        return bookRepository.findByAuthorName(name);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
}

