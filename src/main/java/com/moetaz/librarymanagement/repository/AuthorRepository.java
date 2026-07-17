package com.moetaz.librarymanagement.repository;


import com.moetaz.librarymanagement.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
