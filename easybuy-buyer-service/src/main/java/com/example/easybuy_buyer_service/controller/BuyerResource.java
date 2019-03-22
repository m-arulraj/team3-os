
package com.example.easybuy_buyer_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easybuy_buyer_service.model.Product;
import com.example.easybuy_buyer_service.model.Productcategory;
import com.example.easybuy_buyer_service.services.BuyerService;

@RestController
@RequestMapping(value="/api/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BuyerResource {

	@Autowired
	BuyerService buyerService;
	@GetMapping(value="/{id}")
	public Product getProductById(@PathVariable("id") long id){
	    System.out.println("in /products/"+id+" mapping");
	    Product product=buyerService.getProductById(id);
	    System.out.println(product.getProductcategoryfk().getName());
		return product;
	}
	
	@GetMapping
	public List<Product>getProductList(){
		return buyerService.getProductList();
	}
	
	@GetMapping(value="/filtered/{category}")
	public List<Product> getProductByCategory(@PathVariable("category") String category){
		return buyerService.getProductByCategory(category);
	}
	
	@GetMapping(value="filtered/Price/{order}")
	public List<Product> getProductByPrice(@PathVariable("order") long order){
		return buyerService.getProductByPrice(order);
	}
	
	@GetMapping(value="/categories")
	public List<Productcategory> getCategories(){
		return buyerService.getAllCategories();
	}
}

