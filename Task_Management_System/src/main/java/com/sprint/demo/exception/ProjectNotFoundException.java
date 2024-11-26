package com.sprint.demo.exception;

@SuppressWarnings("serial")
public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String message) {
        super(message);
    }
}
