package com.example.easybuy_seller_service.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.easybuy_seller_service.domain.Product;
import com.example.easybuy_seller_service.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/save_product")
	public ResponseEntity<String> save(@RequestBody Product product) throws URISyntaxException{
		URI uri=new URI("/get_product/"+productService.save(product).getId());
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<String>(headers,HttpStatus.CREATED);
	}

	@GetMapping("/get_product/{id}")
	public Optional<Product> get(@PathVariable Long id){
		return productService.get(id);
	}
	
	@PatchMapping("/update_product/{id}")
	public ResponseEntity<String> update(@PathVariable Long id,@RequestBody Product product) throws URISyntaxException{
		URI uri=new URI("/get_product/"+productService.update(id,product).getId());
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete_product/{id}")
	public ResponseEntity<String>delete(@PathVariable Long id){
		productService.delete(id);
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
}
