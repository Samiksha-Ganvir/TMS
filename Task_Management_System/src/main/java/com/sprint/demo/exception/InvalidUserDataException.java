package com.sprint.demo.exception;

@SuppressWarnings("serial")
public class InvalidUserDataException extends RuntimeException {
    public InvalidUserDataException(String message) {
        super(message);
    }
}

