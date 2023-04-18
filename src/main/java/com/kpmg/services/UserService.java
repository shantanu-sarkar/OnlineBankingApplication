package com.kpmg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpmg.entities.User;
import com.kpmg.repositories.UserRepository;

@Service
public class UserService {

	
	 
	    @Autowired
	    private UserRepository userRepository;

	    public User createUser(User user) {
	        
	       return userRepository.save(user);
	        
	    }
	}

