package com.example.easybuy_buyer_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easybuy_buyer_service.model.Cart;
import com.example.easybuy_buyer_service.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	public void saveCart(Cart cart){
		cartRepository.save(cart);
	}

}
