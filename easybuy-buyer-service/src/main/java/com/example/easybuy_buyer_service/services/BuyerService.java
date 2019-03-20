package com.example.easybuy_buyer_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easybuy_buyer_service.model.Product;
import com.example.easybuy_buyer_service.repository.BuyerRepository;

@Service
public class BuyerService {

	@Autowired
	BuyerRepository buyerRepository;
	public Product getProductById(long id){
		return buyerRepository.getOne(id);
	}
	
	public List<Product> getProductList(){
		return buyerRepository.findAll();
	}
	
	public List<Product> getProductByCategory(String category){
		return buyerRepository.getProductByCategory(category);
	}
	
	public List<Product>getProductByPrice(long order){
		if(order==1){
			return buyerRepository.getProductByAscendingPrice();
		}
		else{
			return buyerRepository.getProductByDescendingPrice();
		}
		
	}
}