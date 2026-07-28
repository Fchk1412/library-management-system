package com.moetaz.librarymanagement.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime borrowDate;

    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public BorrowRecord() {
    }

    public BorrowRecord(LocalDateTime borrowDate, LocalDateTime returnDate, User user, Book book) {
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.user = user;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BorrowRecord that = (BorrowRecord) o;
        return Objects.equals(id, that.id) && Objects.equals(borrowDate, that.borrowDate) && Objects.equals(returnDate, that.returnDate) && Objects.equals(user, that.user) && Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, borrowDate, returnDate, user, book);
    }
}