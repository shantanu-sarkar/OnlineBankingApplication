package com.kpmg.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.entities.User;
import com.kpmg.services.EmailService;
import com.kpmg.services.OtpService;

@Controller
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {
	
	@Autowired
	private EmailService emailService;

	@Autowired
	private OtpService otpService;
	
	@RequestMapping("/forgot")
	public String openEmailForm() {
		return "Forgot_Email_Form";
	}
	
	@PostMapping("/send-otp")
	public void sendEmail(@RequestParam("email") String email) {
		
		System.out.println("Called");
		emailService.sendmail(email, "Forgot Password",otpService.createOtp());
	}
	
	

}
