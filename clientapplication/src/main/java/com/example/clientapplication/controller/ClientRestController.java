package com.example.clientapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientapplication.domain.Cart;
import com.example.clientapplication.domain.OrderDetails;
import com.example.clientapplication.domain.User;
import com.example.clientapplication.service.ClientService;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
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
	
	@GetMapping(value="/api/user")
	public User getAuthenticatedUser(){
		User user=null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			 user = (User) auth.getPrincipal();
		}
		System.out.println(user);
		return user;
	}
	
	@PostMapping(value="/api/user/cart_item")
	public String saveProductToSaveItem(@RequestBody OrderDetails OrderItem){
		return clientService.saveItem(OrderItem);
		
	}
	
	@DeleteMapping(value="/api/user/cart_item")
	public String removeFromCart(@RequestParam("cId") long cId,@RequestParam("pId") long pId){
		clientService.removeItemFromCart(pId, cId);
		 return "ok";
		
	}
}
