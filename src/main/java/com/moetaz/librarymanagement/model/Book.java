package com.moetaz.librarymanagement.model;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
 public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book Book = (Book) o;
        return Objects.equals(id, Book.id) && Objects.equals(title, Book.title) && Objects.equals(author, Book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author);
    }
}
