package com.finalproject.questionsservice.dto;

import com.finalproject.questionsservice.Entity.Questions;
import lombok.Data;

import java.util.List;

@Data
public class QuestionResultDto {
    private Questions questions;
    private Object answers;
}
