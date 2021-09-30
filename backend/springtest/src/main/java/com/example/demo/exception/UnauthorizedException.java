package com.example.demo.exception;

public class UnauthorizedException extends RuntimeException{

    public UnauthorizedException() {
        super(String.format("User is unauthorized to perform this action"));
    }

    public UnauthorizedException(String message, Exception exception) {
        super(message,exception);
    }
}
