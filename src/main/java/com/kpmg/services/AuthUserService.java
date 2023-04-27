package com.kpmg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.HashSet;

import com.kpmg.entities.ApplicationUser;
import com.kpmg.entities.Role;
import com.kpmg.repositories.AuthUserRepository;

@Service
public class AuthUserService implements UserDetailsService {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private AuthUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		System.out.println("In the User Service");
		
		return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not Valid here"));

//		if (!username.equals("abcd"))
//			throw new UsernameNotFoundException("Not Ethan");
//		Set<Role> roles = new HashSet<>();
//		roles.add(new Role(1,"USER"));
//		return new ApplicationUser(1,"Ethan",encoder.encode("password"),roles);
	}

}
