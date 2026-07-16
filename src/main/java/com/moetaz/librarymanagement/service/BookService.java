package com.moetaz.librarymanagement.service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.moetaz.librarymanagement.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<Book>();
    public BookService() {
        books.add(new Book(1, "His last bow", "Conan Doyle"));
        books.add(new Book(2, "The shadow of the wind", "Ruiz Zafon"));
        books.add(new Book(3, "A dance with dragons", "George RR Martin"));
    }

    public List<Book> getBooks() {
        return books;
    }
    public Book getBook(Integer id){
        for(Book book : getBooks()){
            if (book.getId().equals(id)){
                return book;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Book not found"
        );
    }
    public Book createBook(Book book){
        books.add(book);
        return book;
    }
    public Book deleteBook(Integer id){
        Book book = getBook(id);
        books.remove(book);
        return book;
    }

    }

