
package com.example.easybuy_buyer_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.easybuy_buyer_service.model.Cart;
import com.example.easybuy_buyer_service.model.Product;
import com.example.easybuy_buyer_service.model.Productcategory;
import com.example.easybuy_buyer_service.services.BuyerService;
import com.example.easybuy_buyer_service.services.CartService;
import com.example.easybuy_buyer_service.services.SaveProductService;

@RestController
@RequestMapping(value="/api/products")
@CrossOrigin(origins = "*", allowedHeaders = "*",methods={RequestMethod.POST,RequestMethod.GET,RequestMethod.OPTIONS})
public class BuyerResource {

	@Autowired
	BuyerService buyerService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	SaveProductService saveProductService;
	
	
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

	@RequestMapping(value="/add_to_cart",method={RequestMethod.POST,RequestMethod.OPTIONS})
	public HttpStatus addToCart(@RequestBody Cart cart){
		System.out.println(cart.getCustomerfk());
		System.out.println(cart.getProductfk());
		cartService.saveCart(cart);
		return HttpStatus.OK;
	}
	
	@PostMapping("/save_product")
	public void saveProduct(@RequestBody Cart cart){
		saveProductService.saveProduct(cart);
	}
	
	/*@PostMapping("/place_order")
	public void placeOrder(@RequestBody OrderDetails orderDetails){
		orderDetailsService.placeOrder(orderDetails);
	}*/
	
}

