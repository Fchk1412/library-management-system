package com.moetaz.librarymanagement.model;

import java.util.Objects;

public class Book {

    private Integer id;
    private String title;
    private String author;

    public Book() {
    }

    public Book(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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
