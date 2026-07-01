package com.fresherway.fresherway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FresherwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FresherwayApplication.class, args);
	}

}
