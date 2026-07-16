package com.moetaz.librarymanagement.service;

import com.moetaz.librarymanagement.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public List<Book> getBooks() {
        final List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "His last bow", "Conan doyle"));
        books.add(new Book(2, "The shadow of the wind", "Ruiz Zafon"));
        books.add(new Book(3, "A dance with dragons", "George RR Martin"));

        return books;
    }

    }