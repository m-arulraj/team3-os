package com.example.easybuy_buyer_service.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easybuy_buyer_service.domain.Cart;
import com.example.easybuy_buyer_service.domain.Product;
import com.example.easybuy_buyer_service.repository.CartRepository;
import com.example.easybuy_buyer_service.repository.ProductRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductRepository productRepository;
	
	public void saveCart(Cart cart){
		cartRepository.save(cart);
	}

	public List<Product> getAllCartProductsByCustomerId(Long id) {
		List<Product> products=new ArrayList<Product>();
		List<Cart> carts = cartRepository.getAllCartProductsByCustomerId(id);
		carts.forEach(cart->products.add(productRepository.getOne(cart.getProductfk())));
		return products;
	}

	public void deleteFromCartByProductId(Long customerfk,Long productfk) {
		System.out.println("/////////////////");
		cartRepository.deleteFromCartByProductId(customerfk,productfk);
		
	}

}
