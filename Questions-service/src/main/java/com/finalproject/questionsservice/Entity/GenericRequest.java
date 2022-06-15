package com.finalproject.questionsservice.Entity;

import lombok.Data;

@Data
public class GenericRequest {
    private int code ;
    private String message;
    private Object  data ;

}
