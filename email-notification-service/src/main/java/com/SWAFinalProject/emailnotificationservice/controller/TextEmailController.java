package com.SWAFinalProject.emailnotificationservice.controller;

import com.SWAFinalProject.emailnotificationservice.model.EmailTemplate;
import com.SWAFinalProject.emailnotificationservice.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@Slf4j
public class TextEmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping(value="/textemail",consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> sendEmail(@RequestBody EmailTemplate emailTemplate) {
		try {
			log.info("Sending Simple Text Email....");
			emailService.sendSimpleEmail(emailTemplate);
			return new ResponseEntity<EmailTemplate>(emailTemplate, HttpStatus.OK);
		} catch (Exception ex) {
			log.info("Could Not Send Text Email....");

		}
		return new ResponseEntity<EmailTemplate>(emailTemplate, HttpStatus.NO_CONTENT);
	}


}
