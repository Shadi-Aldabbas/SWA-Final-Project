package com.finalproject.ansewerservice.service;

import com.finalproject.ansewerservice.dto.UserDto;
import com.finalproject.ansewerservice.model.Answer;

import java.util.List;
import java.util.UUID;

public interface AnswerService {
    Answer add(Answer answer, UserDto user);

    List<Answer> findAll();

    Answer getById(String id);

    List<Answer> getByAnswerQuestionId(String id);

    Boolean deleteByID(String id);

    Answer update(Answer answer);
}
