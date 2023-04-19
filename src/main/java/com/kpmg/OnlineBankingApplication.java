package com.kpmg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan({"com.kpmg"})
@EntityScan("com.kpmg.entities")
@EnableJpaRepositories("com.kpmg.repositories")
public class OnlineBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBankingApplication.class, args);
	}
	
	

}
