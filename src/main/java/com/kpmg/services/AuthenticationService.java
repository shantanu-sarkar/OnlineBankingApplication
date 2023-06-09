package com.kpmg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kpmg.entities.ApplicationUser;
import com.kpmg.repositories.AuthUserRepository;
import com.kpmg.repositories.RoleRepository;

import jakarta.transaction.Transactional;

import com.kpmg.entities.*;
import java.util.*;

@Service
@Transactional
public class AuthenticationService {

	@Autowired
	private AuthUserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	public ApplicationUser registerUser(String firstName,String middleName,String lastName,String FathersName,long mobileNo,String email,long AadharNo,Date dateOfBirth,String username,String password) {
		
		String encodedPassword = passwordEncoder.encode(password); 
		Role userRole =roleRepository.findByAuthority("USER").get(); 
		Set<Role> authorities =new HashSet<>();
		
		authorities.add(userRole);
		return userRepository.save(new ApplicationUser(0,username,encodedPassword,firstName,middleName,lastName,FathersName,mobileNo,email,AadharNo,dateOfBirth,authorities));
	}
	
	public LoginResponseDTO loginUser(String username,String password) {
		

		try {

					Authentication auth =authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username,password) );
			String token =tokenService.generateJwt(auth);
			
			return new LoginResponseDTO(userRepository.findByUsername(username).get(),token);
			
		} catch(AuthenticationException e) {
			return new LoginResponseDTO(null,"");
		}
		
	}
	
	
}
