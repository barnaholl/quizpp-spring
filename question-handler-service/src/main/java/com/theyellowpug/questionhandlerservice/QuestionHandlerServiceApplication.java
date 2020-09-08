package com.theyellowpug.questionhandlerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class QuestionHandlerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionHandlerServiceApplication.class, args);
	}

}
