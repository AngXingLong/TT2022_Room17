package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(RecordNotFoundException e) {
        ExceptionResponse response = new ExceptionResponse(HttpStatus.NOT_FOUND, e);
        return new ResponseEntity(response, response.getHttpStatus());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public final ResponseEntity<ExceptionResponse> unauthorizedException(UnauthorizedException e) {
        ExceptionResponse response = new ExceptionResponse(HttpStatus.UNAUTHORIZED, e);
        return new ResponseEntity(response, response.getHttpStatus());
    }

}