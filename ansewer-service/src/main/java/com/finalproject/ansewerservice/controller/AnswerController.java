package com.finalproject.ansewerservice.controller;

import com.finalproject.ansewerservice.dto.GenericResponse;
import com.finalproject.ansewerservice.helpers.JwtHelper;
import com.finalproject.ansewerservice.model.Answer;
import com.finalproject.ansewerservice.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.UUID;


@RestController
@RequestMapping("api/v1/answers")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    JwtHelper jwt = new JwtHelper();



    private RestTemplate restTemplate;
    Logger logger = LoggerFactory.getLogger(AnswerController.class);

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Answer answer,@RequestHeader (name="Authorization") String token){
        logger.info("add answer - progress started");
        var loUser = jwt.getUserFromToken(jwt.parseToken(token));
        answer.setUser_id(loUser.getUserId());
       var result = answerService.add(answer, loUser);
       if(result.getId() != null){
           logger.info("add answer - Answer added successfully. Answer ID: "+result.getId());
           return ResponseEntity.ok(new GenericResponse("Answer added successfully",200,result));
       }
        logger.info("add answer - There is a problem while inserting an answer.");
      return ResponseEntity.badRequest().body(new GenericResponse("There is an error while adding answer",-1,null));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        var result = answerService.findAll();
        return ResponseEntity.ok(new GenericResponse(result.size()+" Answer found", 200,result));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Answer answer){
        var loAnswer = answerService.getById(id);
        if(loAnswer.getId() == null){
            return ResponseEntity.ok(new GenericResponse("Answer not found", -1,false));
        }
        loAnswer.setDescription(answer.getDescription());
        var result = answerService.update(loAnswer);

        return ResponseEntity.ok(new GenericResponse("Answer has been updated!", 200,result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){

        if(answerService.deleteByID(id)){
            return ResponseEntity.ok(new GenericResponse("Answer has been deleted successfully", 200,true));
        }
        return ResponseEntity.ok(new GenericResponse("Answer can not be deleted. Try again", -1,false));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getAnserById(@PathVariable String id){

        var result = answerService.getById(id);
        if(result.getId() != null){
            return ResponseEntity.ok(new GenericResponse("Answer Found",200,result));
        }

        return ResponseEntity.badRequest().body(new GenericResponse("There is an error",-1,null));
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<?> getAnswerByQuestionId(@PathVariable String id){

       var result = answerService.getByAnswerQuestionId(id);
        if(result.size() > 0){
            return ResponseEntity.ok(new GenericResponse(result.size()+" Answer Found",200,result));
        }

        return ResponseEntity.badRequest().body(new GenericResponse("No answer found for ",-1,null));
    }



}
