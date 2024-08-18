package com.semicolon.africa.Exceptions;

public class UserDoesNotExistException extends RuntimeException {
    public UserDoesNotExistException(String userNotFound) {
        super(userNotFound);
    }
}
