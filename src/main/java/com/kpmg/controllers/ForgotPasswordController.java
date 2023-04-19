package com.kpmg.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.entities.User;

@Controller
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {
	Random random= new Random(100001);
	
	@RequestMapping("/forgot")
	public String openEmailForm() {
		return "Forgot_Email_Form";
	}
	
	@PostMapping("/send-otp")
	public String sendOTP(@RequestParam("email") String email) 
	{
		System.out.println("Email:"+email);
		
		//generating  otp for 5 digit
		
		
		int otp=random.nextInt(999999);
		
		System.out.println("OTP:"+otp);
		return "Verify_otp";
	}
	
	

}
