package com.kpmg.services;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kpmg.controllers.ForgotPasswordController;

@Service
public class EmailService {

	
	@Autowired
	private JavaMailSender mailsender;
	
	


	public void sendmail(String toEmail, String subject, int i) {
		// TODO Auto-generated method stub
		SimpleMailMessage m= new SimpleMailMessage();
		m.setFrom("btech10333.19@bitmesra.ac.in");
		m.setTo(toEmail);
		m.setText(Integer.toString(i));
		m.setSubject(subject);
		
	 
		
		mailsender.send(m);
		System.out.println("Email Sent Successsfully....");
	}
}
