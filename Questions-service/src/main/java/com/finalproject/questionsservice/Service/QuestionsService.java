package com.finalproject.questionsservice.Service;

import com.finalproject.questionsservice.Entity.Questions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface QuestionsService {

    Questions addQuestions(Questions questions);
    Questions getQuestionsById(String id);
    List<Questions> getAllQuestions();
    List<Questions> getQuestionsByTitle(String title);
    List<Questions> getQuestionsByDescription(String description);
    Boolean deleteQuestionsById(String id);
    Questions updateQuestions(Questions questions);






}
