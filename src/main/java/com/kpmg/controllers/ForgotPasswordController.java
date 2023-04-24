package com.kpmg.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.entities.User;
import com.kpmg.repositories.UserRepository;
import com.kpmg.services.EmailService;
import com.kpmg.services.OtpService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {
	
	@Autowired
	private EmailService emailService;

	@Autowired
	private OtpService otpService;
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder bcrypt;
	
	@RequestMapping("/forgot")
	public String openEmailForm() {
		return "Forgot_Email_Form";
	}
	
	@PostMapping("/send-otp")
	public String sendEmail(@RequestParam("email") String email,HttpSession session) {
		String subject="Forgot Password";
		int otp=otpService.createOtp();
		String to=email;
		
		session.setAttribute("myotp", otp);
		session.setAttribute("email", email);
		session.setAttribute("subject", subject);
		emailService.sendmail(to, subject, otp);
		return "Verify_otp";
		
	}
	
	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestParam("otp") int otp,HttpSession session) 
	{
		Integer myOtp=(int)session.getAttribute("myotp");
		String email=(String)session.getAttribute("email");
		
		if(myOtp==otp)
		{
			//checking that user is available on system or not....
		User user=	this.userRepository.getByEmailID(email);
		if(user==null) 
		{
			//send error message that is user is not available......
			return "Forgot_Email_Form";
		}
		else 
		{
			//User is available and password change form will open......
			return "password_Change_Form";
		}
			
			
		}
		else 
		{
			
			return "Verify_otp";
		}
		

	}
	
	@PostMapping("/change-password")
	public String changePassword(@RequestParam("newpassword") String newpassword,HttpSession session ) {
		
		String email=(String)session.getAttribute("email");
		User user=this.userRepository.getByEmailID(email);
		
		user.setPassword(newpassword);
		this.userRepository.save(user);
		
		return "your password has been changed";
	}
	
	
	
	
	

}
