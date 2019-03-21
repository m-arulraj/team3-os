<<<<<<< HEAD
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
=======
package com.example.easybuy_buyer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
>>>>>>> 87b23634b52c5b20860bfbb7f45ace87c51fe1d0
