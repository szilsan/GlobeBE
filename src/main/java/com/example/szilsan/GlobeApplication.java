package com.example.szilsan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class GlobeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobeApplication.class, args);
	}
}
