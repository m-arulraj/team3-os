
<<<<<<< HEAD
package com.example.easybuy_buyer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class App 
{
	 public static void main(String[] args) {
	        SpringApplication.run(App.class, args);
	    }
}
=======
package com.example.easybuy_buyer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class App 
{
	 public static void main(String[] args) {
	        SpringApplication.run(App.class, args);
	    }
}



>>>>>>> 520e53cedd0ad6135f041d456a0db7d2cd3ebe9c
