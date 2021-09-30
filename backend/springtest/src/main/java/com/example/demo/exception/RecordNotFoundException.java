package com.example.demo.exception;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(Long id) {
        super(String.format("Record with id %d cannot be found",id));
    }

    public RecordNotFoundException(String name) {
        super(String.format("Record %s cannot be found",name));
    }

    public RecordNotFoundException(String message, Exception exception) {
        super(message,exception);
    }
}
