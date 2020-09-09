package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserExistsException extends RuntimeException{

    public UserExistsException(String message) {
        super(message);
    }
}
