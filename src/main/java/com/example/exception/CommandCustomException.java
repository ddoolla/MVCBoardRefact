package com.example.exception;

public class CommandCustomException extends RuntimeException {
    public CommandCustomException() {}

    public CommandCustomException(String message) {
        super(message);
    }
}
