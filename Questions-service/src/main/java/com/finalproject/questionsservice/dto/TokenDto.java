package com.finalproject.questionsservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenDto {
    private String userId;
    private String name;
    private String userName;
    private String emailAddress;
    private List<String> roles;
}



