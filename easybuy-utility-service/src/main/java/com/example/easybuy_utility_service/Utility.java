package com.example.easybuy_utility_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Utility {

	public static void main(String[] args) {
		SpringApplication.run(Utility.class, args);
	}
}
