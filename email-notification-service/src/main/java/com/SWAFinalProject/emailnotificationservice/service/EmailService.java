package com.SWAFinalProject.emailnotificationservice.service;


import com.SWAFinalProject.emailnotificationservice.model.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

//	String toEmail,
//	String body,
//	String subject

	public void sendSimpleEmail(EmailTemplate emailTemplate) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("stackunderflow2@gmail.com");
		message.setTo(emailTemplate.getSendTo());
		message.setText(emailTemplate.getBody());
		message.setSubject(emailTemplate.getSubject());

		mailSender.send(message);
		System.out.println("Mail Send...");
	}


}