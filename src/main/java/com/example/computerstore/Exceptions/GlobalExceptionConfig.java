package com.example.computerstore.Exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class GlobalExceptionConfig extends RuntimeException {
    private final HttpStatus httpStatus;
    public GlobalExceptionConfig(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
