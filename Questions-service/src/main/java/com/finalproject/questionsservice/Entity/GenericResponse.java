package com.finalproject.questionsservice.Entity;

import lombok.Data;

@Data
public class GenericResponse {
    private int code ;
    private String message;
    private Object data ;

    public GenericResponse(String message, int code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }
    }

