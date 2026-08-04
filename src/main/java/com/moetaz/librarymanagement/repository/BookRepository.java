package com.moetaz.librarymanagement.repository;

import com.moetaz.librarymanagement.dto.BookDto;
import com.moetaz.librarymanagement.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    List<Book> findByAuthorName(String name, Sort sort);
}
