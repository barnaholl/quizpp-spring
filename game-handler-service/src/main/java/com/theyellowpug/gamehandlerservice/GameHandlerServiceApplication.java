package com.theyellowpug.gamehandlerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GameHandlerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameHandlerServiceApplication.class, args);
	}

}
