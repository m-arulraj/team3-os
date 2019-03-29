package com.example.clientapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientapplication.domain.Cart;
import com.example.clientapplication.domain.OrderDetails;
import com.example.clientapplication.service.ClientService;

@RestController
public class ClientRestController {

	@Autowired
	ClientService clientService;
	@PostMapping(value="/api/addToCart")
	public String addToCart(@RequestBody Cart cart){
		System.out.println(cart.getCustomerfk()+cart.getProductfk());
	    String reponseString=clientService.addToCart(cart);	
		return reponseString;
	}

	@PostMapping(value="/api/order")
	public String register(@RequestBody OrderDetails orderDetails){
	System.out.println(orderDetails.getStatus()+orderDetails.getCustomerfk()+orderDetails.getProductfk()+orderDetails.getDate());
	    String reponseString=clientService.placeOrder(orderDetails);	
		return reponseString;
	}
}
