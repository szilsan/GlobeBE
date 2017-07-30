package com.example.szilsan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@ComponentScan(excludeFilters = @ComponentScan.Filter(pattern = "com.example.szilsan.web.*", type = FilterType.REGEX))
public class GlobeApplicationLocal {

	public static void main(String[] args) {
		new SpringApplicationBuilder(GlobeApplicationLocal.class).web(false).run(args);;
	}
}
