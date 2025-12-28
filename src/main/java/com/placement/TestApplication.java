package com.placement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
	    "com.placement.controller",
	    "com.placement.IService",
	    "com.placement.service",
	    "com.placement.entity",
	    "com.placement.repository",
	    "com.placement.config"
	})
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
