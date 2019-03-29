
package com.example.clientapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.clientapplication.domain.Cart;
import com.example.clientapplication.service.ClientService;


@Controller
@CrossOrigin(origins="*",allowedHeaders="*")
public class HtmlController {
	
	@Autowired
	ClientService clientService;

	@GetMapping(value="/")
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
	
	@GetMapping(value="/product/details")
	public String getDetailedPage(@RequestParam("id") long id){
		System.out.println("details");		
		return "productDetails";
		
	}
	@GetMapping(value="/cart")
	public String getCartPage(){	
		return "userCart";
		
	}
	
	/*@PostMapping(value="/add_to_cart")
	public String addToCart(@RequestBody Cart cart){
		System.out.println(cart.getCustomerfk()+cart.getProductfk());
	    String reponseString=clientService.addToCart(cart);	
		return "productDetails";
		
	}*/
	
}



