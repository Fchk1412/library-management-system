package com.moetaz.librarymanagement.exception;

public class UserNotFoundExeption extends RuntimeException {
    public UserNotFoundExeption(Integer id) {
        super("USER WITH ID "+id+" IS NOT FOUND");
    }
}
