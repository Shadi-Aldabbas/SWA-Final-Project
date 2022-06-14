package com.SWAFinalProject.userservice.exception;

import lombok.Getter;

import static org.springframework.http.HttpStatus.CONFLICT;


@Getter
public class DataDuplicationException extends RuntimeException {

    private ExceptionResponse exception;

    public DataDuplicationException(String errorMessage) {
        setErrorResponse(errorMessage, errorMessage);
    }


    private void setErrorResponse(String errorMessage, String debugMessage) {
        exception = ExceptionResponse.builder()
                .errorMessage(errorMessage)
                .debugMessage(debugMessage)
                .responseStatus(CONFLICT)
                .responseCode(CONFLICT.value())
                .build();
    }

}
