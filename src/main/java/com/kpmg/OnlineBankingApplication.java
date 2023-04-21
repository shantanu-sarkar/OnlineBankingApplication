package com.kpmg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan({"com.kpmg"})
@EntityScan("com.kpmg.entities")
@EnableJpaRepositories("com.kpmg.repositories")
public class OnlineBankingApplication {
	Random random= new Random(1000001);
	

	public static void main(String[] args) {
		SpringApplication.run(OnlineBankingApplication.class, args);
	}
	

	
	

}
