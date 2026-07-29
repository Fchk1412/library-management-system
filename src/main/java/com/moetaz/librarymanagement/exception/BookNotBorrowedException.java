package com.moetaz.librarymanagement.exception;

public class BookNotBorrowedException extends RuntimeException {
    public BookNotBorrowedException(Integer id) {
        super("THE BOOK WITH ID "+id+" IS NOT BORROWED");
    }
}
