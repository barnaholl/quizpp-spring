package com.theyellowpug.gamehandlerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
public class GameHandlerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameHandlerServiceApplication.class, args);
	}
}

