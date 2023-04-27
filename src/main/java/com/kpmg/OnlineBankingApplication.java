package com.kpmg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;


import com.kpmg.services.EmailService;

import java.util.Set;
import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kpmg.entities.*;
import com.kpmg.repositories.AuthUserRepository;
import com.kpmg.repositories.RoleRepository;


//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan({"com.kpmg"})
@EntityScan("com.kpmg.entities")
@EnableJpaRepositories("com.kpmg.repositories")

@SpringBootApplication
public class OnlineBankingApplication {

	Random random= new Random(1000001);

	public static void main(String[] args) {
		SpringApplication.run(OnlineBankingApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(RoleRepository roleRepository,AuthUserRepository userRepository,PasswordEncoder passwordEncoder){
		
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			
			roleRepository.save(new Role("USER"));
			
			Set<Role> roles=new HashSet<>();
			roles.add(adminRole);
			
			
			ApplicationUser admin=new ApplicationUser(1,"admin",passwordEncoder.encode("password"),roles);
			
			userRepository.save(admin);
		};
	}

}


