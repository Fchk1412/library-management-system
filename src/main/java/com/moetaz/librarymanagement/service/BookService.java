package com.moetaz.librarymanagement.service;

import com.moetaz.librarymanagement.dto.BookDto;
import com.moetaz.librarymanagement.dto.BorrowBookRequest;
import com.moetaz.librarymanagement.dto.CreateBookRequest;
import com.moetaz.librarymanagement.dto.UpdateBookRequest;
import com.moetaz.librarymanagement.exception.*;
import com.moetaz.librarymanagement.mapper.BookMapper;
import com.moetaz.librarymanagement.model.Author;
import com.moetaz.librarymanagement.model.BorrowRecord;
import com.moetaz.librarymanagement.model.User;
import com.moetaz.librarymanagement.repository.AuthorRepository;
import com.moetaz.librarymanagement.repository.BookRepository;
import com.moetaz.librarymanagement.repository.BorrowRecordRepository;
import com.moetaz.librarymanagement.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.moetaz.librarymanagement.model.Book;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final UserRepository userRepository;
    private final BorrowRecordRepository borrowRecordRepository;

    public BookService(BookRepository bookRepository,
            AuthorRepository authorRepository,
            UserRepository userRepository,
            BorrowRecordRepository borrowRecordRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
        this.borrowRecordRepository = borrowRecordRepository;
    }

    // =========================
    // Private helper methods
    // =========================

    private Book findBookOrThrow(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    private Author findAuthorOrThrow(Integer id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    private User findUserOrThrow(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    private BorrowRecord findActiveBorrowRecordOrThrow(Integer id) {
        return borrowRecordRepository.findByBookIdAndReturnDateIsNull(id)
                .orElseThrow(() -> new BookNotBorrowedException(id));
    }

    // =========================
    // Public service methods
    // =========================

    public Page<BookDto> findAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable).map(BookMapper::toDto);
    }

    public BookDto getBook(Integer id) {
        return BookMapper.toDto(findBookOrThrow(id));
    }

    public BookDto deleteBook(Integer id) {
        Book book = findBookOrThrow(id);
        bookRepository.delete(book);
        return BookMapper.toDto(book);
    }

    public BookDto updateBook(Integer id, UpdateBookRequest request) {
        Book book = findBookOrThrow(id);
        book.setTitle(request.getTitle());
        Author author = findAuthorOrThrow(request.getAuthorId());
        book.setAuthor(author);
        bookRepository.save(book);
        return BookMapper.toDto(book);
    }

    @Transactional
    public BookDto borrowBook(Integer bookId, BorrowBookRequest request) {
        Book book = findBookOrThrow(bookId);
        User user = findUserOrThrow(request.getUserId());
        if (!book.isAvailable()) {
            throw new BookNotAvailableException(bookId);
        }
        BorrowRecord record = new BorrowRecord(
                LocalDateTime.now(),
                null,
                user,
                book);
        book.setAvailable(false);
        borrowRecordRepository.save(record);
        return BookMapper.toDto(book);

    }

    public Page<BookDto> getBooksByTitle(String title,Pageable pageable) {
        return bookRepository
                .findByTitleContainingIgnoreCase(title, pageable)
                .map(BookMapper::toDto);

    }

    public List<BookDto> getBooksByAuthorSorted(String name, Sort sort) {
        List<Book> books = bookRepository.findByAuthorName(name, sort);
        return BookMapper.toListDto(books);
    }

    public BookDto createBook(CreateBookRequest request) {
        Author author = findAuthorOrThrow(request.getAuthorId());
        Book book = new Book(request.getTitle(), author);
        bookRepository.save(book);
        return BookMapper.toDto(book);
    }

    @Transactional
    public BookDto returnBook(Integer bookId) {
        Book book = findBookOrThrow(bookId);
        BorrowRecord borrowRecord = findActiveBorrowRecordOrThrow(bookId);
        book.setAvailable(true);
        borrowRecord.setReturnDate(LocalDateTime.now());
        return BookMapper.toDto(book);
    }
}
