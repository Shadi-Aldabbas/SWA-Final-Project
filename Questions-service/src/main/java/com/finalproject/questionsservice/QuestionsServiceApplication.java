package com.finalproject.questionsservice;

import com.finalproject.questionsservice.Helpers.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestionsServiceApplication {


    public static void main(String[] args) {

        new JwtHelper().validateToken("ab abc");
        SpringApplication.run(QuestionsServiceApplication.class, args);
    }

}
