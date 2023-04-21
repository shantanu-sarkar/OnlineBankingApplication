package com.kpmg.services;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class OtpService {
	 Random random= new Random(100001);
	
	public int createOtp()
	{
		int otp = random.nextInt(999999);
		return otp;
	}
}
