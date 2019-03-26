package com.example.easybuy_buyer_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easybuy_buyer_service.domain.Cart;
import com.example.easybuy_buyer_service.repository.SaveProductRepository;

@Service
public class SaveProductService {

	@Autowired
	SaveProductRepository saveProductRepository;
	
	public void saveProduct(Cart cart){
		saveProductRepository.save(cart);
	}
}
