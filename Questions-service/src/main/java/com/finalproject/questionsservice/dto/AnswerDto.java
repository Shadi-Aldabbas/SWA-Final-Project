package com.finalproject.questionsservice.dto;

import lombok.Data;


@Data
public class AnswerDto {
    private String id;
    private String question_id;
    private String user_id;
    private String description;
    private Boolean is_deleted;
}
