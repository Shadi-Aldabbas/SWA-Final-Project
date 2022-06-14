package com.SWAFinalProject.emailnotificationservice.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class EmailTemplate {

	private String sendTo;
	private String subject;
	private String body;

	public static final String footer = "\n\nSincerely,\nStackUnderFlow2 Team";

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public static EmailTemplate sendAnswerEmail(User user){
		String body = "Dear " + user.getId() +
				",\n\nThere is an answer to your question." + footer;
		return
				new EmailTemplate(user.getEmail(), "Your Question is answered", body);
	}

	public static EmailTemplate sendUserEmail(User user){
		String body = "Dear " + user.getId() +
				",\n\nYour account has been created successfully." + footer;
		return
				new EmailTemplate(user.getEmail(), "Welcome to StackUnderFlow2", body);
	}

}
