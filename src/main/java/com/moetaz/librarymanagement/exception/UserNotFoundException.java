package com.moetaz.librarymanagement.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
        super("USER WITH ID "+id+" IS NOT FOUND");
    }

}
