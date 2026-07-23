package com.moetaz.librarymanagement.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Integer id) {
        super("AUTHOR WITH ID "+id + " IS NOT FOUND");
    }
}
