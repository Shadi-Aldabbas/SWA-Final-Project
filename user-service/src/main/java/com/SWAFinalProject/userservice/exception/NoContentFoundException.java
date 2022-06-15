package com.SWAFinalProject.userservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoContentFoundException extends RuntimeException {

    public NoContentFoundException(String errorMessage) {
        super(errorMessage);
    }
}
