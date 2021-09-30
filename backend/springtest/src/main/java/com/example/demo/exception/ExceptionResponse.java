package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;

@JsonIgnoreProperties(value={"httpStatus"})
public class ExceptionResponse {
    private int code;
    private String error;
    private String message;
    private HttpStatus httpStatus;

    ExceptionResponse (HttpStatus httpStatus, String message){
        this.httpStatus = httpStatus;
        this.message = message;
        error = httpStatus.getReasonPhrase();
        code = httpStatus.value();
    }

    ExceptionResponse (HttpStatus httpStatus, Exception exception){
        this.httpStatus = httpStatus;
        this.message = exception.getMessage();
        error = httpStatus.getReasonPhrase();
        code = httpStatus.value();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
