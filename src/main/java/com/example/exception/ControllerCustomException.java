package com.example.exception;

public class ControllerCustomException extends RuntimeException {
    public ControllerCustomException() {}
    public ControllerCustomException(String message) {
        super(message);
    }
}
