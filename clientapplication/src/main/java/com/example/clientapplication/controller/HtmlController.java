package com.example.clientapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HtmlController {
	


	@GetMapping(value="/home")
	public String getHomePage(){
		System.out.println("home controller");
		return "home";
	//	clientService.getAllProduct();
	}
	
	@GetMapping(value="/registration")
	public String getRegistrationPage(){
		System.out.println("registration controller");
		return "registration";
	}
	
	@GetMapping(value="/login")
	public String getLogInPage(){
		System.out.println("login controller");
		return "login";
	}
	
	@GetMapping(value="/upload")
	public String getUploadPage(){
		System.out.println("upload controller");
		return "upload";
	}
	
}



