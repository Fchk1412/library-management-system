package com.moetaz.librarymanagement.exception;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(Integer id) {
        super("BOOK WITH ID "+id+" NOT FOUND");
    }
}
