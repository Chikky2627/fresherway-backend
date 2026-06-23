package com.fresherway.fresherway.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(
            String message) {

        super(message);
    }
}