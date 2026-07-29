package com.moetaz.librarymanagement.exception;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException(Integer id) {
        super("THE BOOK WITH ID "+id+" IS CURRENTLY NOT AVAILABLE" );
    }
}
