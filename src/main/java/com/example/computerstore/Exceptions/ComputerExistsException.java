package com.example.computerstore.Exceptions;

public class ComputerExistsException extends RuntimeException {
    public ComputerExistsException(String message) {
        super(message);
    }
}
