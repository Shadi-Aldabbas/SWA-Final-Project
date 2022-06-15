package com.SWAFinalProject.emailnotificationservice.listener;

import com.SWAFinalProject.emailnotificationservice.model.EmailTemplate;
import com.SWAFinalProject.emailnotificationservice.model.User;
import com.SWAFinalProject.emailnotificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "app", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    @KafkaListener(topics = "user", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        emailService.sendSimpleEmail(EmailTemplate.sendUserEmail(user));
        System.out.println("Consumed JSON Message: " + user);
    }

//    @KafkaListener(topics = "answer", containerFactory = "userKafkaListenerFactory")
//    public void consumeJsonAnswer(User user) {
//        emailService.sendSimpleEmail(EmailTemplate.sendAnswerEmail(user));
//        System.out.println("Consumed JSON Message: " + user);
//    }
}
