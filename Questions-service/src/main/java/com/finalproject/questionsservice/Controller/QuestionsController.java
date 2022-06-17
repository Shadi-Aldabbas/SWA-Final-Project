package com.finalproject.questionsservice.Controller;
import com.finalproject.questionsservice.Entity.GenericRequest;
import com.finalproject.questionsservice.Entity.GenericResponse;
import com.finalproject.questionsservice.Entity.Questions;
import com.finalproject.questionsservice.Helpers.JwtHelper;
import com.finalproject.questionsservice.Service.QuestionsService;
import com.finalproject.questionsservice.dto.QuestionResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/v1/questions")
public class QuestionsController {

    @Autowired
    QuestionsService questionsService;

    JwtHelper jwt= new JwtHelper();

    private RestTemplate restTemplate;


    @Value("${app.answer_service}")
    private String answerUrl ;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Questions questions,@RequestHeader (name="Authorization") String token){
        System.out.println(answerUrl);
        if(jwt.validateToken(token)){
            var loUser= jwt.getUserFromToken(token);
            if(loUser.getUserId() != null){
                questions.setUser_id(loUser.getUserId());
                Questions qt = questionsService.addQuestions(questions);
                return ResponseEntity.ok( new GenericResponse("Added Question Successfully", 200, qt));
            }
            return ResponseEntity.status(401).body(new GenericResponse("User not found!", 404, null));
        }else{
            return ResponseEntity.status(401).body(new GenericResponse("Authorization Error", 401, null));
        }

    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Questions> qt =questionsService.getAllQuestions();
        return ResponseEntity.ok(new GenericResponse("Successful Getting", 200,qt ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        Questions qt = questionsService.getQuestionsById(id);

        //logger.info("qdd question - progress started");
        var getAnswers  = new RestTemplate().getForEntity(answerUrl+"/question/"+id,  GenericRequest.class);
        List<Object> allAnswers = new ArrayList<Object>();

        QuestionResultDto a = new QuestionResultDto();
        a.setQuestions(qt);

        a.setAnswers(getAnswers.getBody());
        if(qt != null){
            return ResponseEntity.ok(new GenericResponse("Question Found.", 200, a));
        }
        return ResponseEntity.ok(new GenericResponse("Question's id NOT Found", -1, null));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> getByTitle(@RequestParam String title){
        List<Questions> qt = questionsService.getQuestionsByTitle(title);
        if(qt.size()>0){
            return ResponseEntity.ok(new GenericResponse("Question's title Found", 200, qt));
        }
        return ResponseEntity.ok(new GenericResponse("Question's title NOT Found", -1, null));
    }

    @GetMapping("/filters")
    public ResponseEntity<?> getByDescription(@RequestParam String description){
        List<Questions> qt =questionsService.getQuestionsByDescription(description);
        if(qt.size()>0){
            return ResponseEntity.ok(new GenericResponse("Description's question Found", 200, qt));
        }
        return ResponseEntity.ok(new GenericResponse("Description's question NOT Found", -1, null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Questions questions,@RequestHeader (name="Authorization") String token){
        if(jwt.validateToken(token) && jwt.getUserFromToken(token).getUserId() != null){
            Questions qt = questionsService.getQuestionsById(id);
            if(qt.getId()== null){
                return ResponseEntity.badRequest().body(new GenericResponse("Question NOT Found", -1, null));
            }
            qt.setDescription(questions.getDescription());
            questionsService.updateQuestions(qt);
            return ResponseEntity.ok(new GenericResponse("Question updated succesfully", 200, qt));
        }else{

            return ResponseEntity.status(401).body(new GenericResponse("Authorization Error", 401, null));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id,@RequestHeader (name="Authorization") String token){
        if(jwt.validateToken(token) && jwt.getUserFromToken(token).getUserId() != null){
            Boolean qt = questionsService.deleteQuestionsById(id);
            if(qt){
                return ResponseEntity.ok(new GenericResponse("Question deleted succesfully", 200, null));
            }
            return ResponseEntity.ok(new GenericResponse("Failed", -1, null));
        }

        return ResponseEntity.status(401).body(new GenericResponse("Authorization Error", 401, null));
    }

}