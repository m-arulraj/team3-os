package com.example.clientapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.clientapplication.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@GetMapping("/home")
	public ModelAndView home(){
		ModelAndView model=new ModelAndView("home");
		model.addObject("productList", clientService.getAllProduct());
		return model;
	}
}
