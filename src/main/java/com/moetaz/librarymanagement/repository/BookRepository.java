package com.moetaz.librarymanagement.repository;

import com.moetaz.librarymanagement.model.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
  //  List<Book> findByAuthorName(String name);

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByAuthorName(String name, Sort sort);
}
