package com.sprint.demo.exception;

@SuppressWarnings("serial")

public class ProjectAlreadyExistException extends RuntimeException {
    public ProjectAlreadyExistException(String message) {
        super(message);
    }
}

