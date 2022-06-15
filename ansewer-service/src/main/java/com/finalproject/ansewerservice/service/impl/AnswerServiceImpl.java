package com.finalproject.ansewerservice.service.impl;

import com.finalproject.ansewerservice.dto.UserDto;
import com.finalproject.ansewerservice.model.Answer;
import com.finalproject.ansewerservice.repo.AnswerRepo;
import com.finalproject.ansewerservice.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepo answerRepo;

    @Autowired
    KafkaTemplate<String, List<String>> kafkaTemplate;

    private static final String TOPIC = "answer";
    @Override
    public Answer add(Answer answer, UserDto user) {
        List<String> userandAnswer = new ArrayList<>();
        answerRepo.save(answer);
        userandAnswer.add(answer.getId());
        userandAnswer.add(user.getEmailAddress());

        var result = answerRepo.save(answer);
       // kafkaTemplate.send(TOPIC,userandAnswer);
        answer.setIs_deleted(false);
        return result;
    }

    @Override
    public List<Answer> findAll() {
        return answerRepo.findAll();
    }

    @Override
    public Answer getById(String id) {
        return answerRepo.findById(id).orElseGet(()->new Answer());

    }

    @Override
    public List<Answer> getByAnswerQuestionId(String id) {
        var result = answerRepo.findAllByQuestion(id);

        return result;
    }

    @Override
    public Boolean deleteByID(String id) {
        var findAnswer = answerRepo.findById(id);
        if (findAnswer.isPresent()){
            var result = findAnswer.get();
            result.setIs_deleted(true);
            answerRepo.save(result);
            return true;
        }
        return false;
    }

    @Override
    public Answer update(Answer answer) {
        var result = answerRepo.save(answer);
        return result;
    }
}











