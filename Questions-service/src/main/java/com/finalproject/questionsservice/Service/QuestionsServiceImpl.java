package com.finalproject.questionsservice.Service;
import com.finalproject.questionsservice.Entity.Questions;
import com.finalproject.questionsservice.Repo.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class QuestionsServiceImpl implements QuestionsService {
    @Autowired
    private QuestionsRepo questionsRepo;

    @Override
    public Questions addQuestions(Questions questions) {

        questions.set_deleted(false);
        return questionsRepo.save(questions);
    }

    @Override
    public List<Questions> getAllQuestions() {
        List<Questions> qt = new ArrayList<Questions>();
        questionsRepo.findAll().forEach(x -> {
            if (!x.is_deleted()) {

                qt.add(x);
            }
        });
        return qt;
    }

    @Override
    public Questions getQuestionsById(String id) {
        Questions qt = questionsRepo.findById(id).filter(questions -> questions.is_deleted() == false).orElse(new Questions());
        return qt;
    }

    @Override
    public List<Questions> getQuestionsByTitle(String title) {
        List<Questions> qt = new ArrayList<Questions>();
        questionsRepo.findByTitleContaining(title).forEach(x -> {
            if (!x.is_deleted()) {
                qt.add(x);
            }
        });
        return qt;
    }

    @Override
    public List<Questions> getQuestionsByDescription(String description) {
        List<Questions> qt = new ArrayList<Questions>();
        questionsRepo.findByDescription(description).forEach(x -> {
            if (!x.is_deleted()) {
                qt.add(x);
            }
        });
        return qt;
    }


    @Override
    public Boolean deleteQuestionsById(String id) {
        Optional<Questions> findQuestion = questionsRepo.findById(id);
        if (findQuestion.isPresent()) {
            Questions newQuestion = findQuestion.get();
            newQuestion.set_deleted(true);
            questionsRepo.save(newQuestion);
            return true;
        }
        return false;
    }

    @Override
    public Questions updateQuestions(Questions questions) {
        return questionsRepo.save(questions);

    }
}

