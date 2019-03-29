package com.example.easybuy_buyer_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easybuy_buyer_service.domain.Product;
import com.example.easybuy_buyer_service.domain.Saveproduct;
import com.example.easybuy_buyer_service.repository.SaveProductRepository;

@Service
public class SaveProductService {

	@Autowired
	SaveProductRepository saveProductRepository;
	@Autowired
	CartService cartService;
	
	public void saveProduct(Saveproduct saveProduct){
		cartService.deleteFromCartByProductId(saveProduct.getProductfk(),saveProduct.getCustomerfk());
		saveProductRepository.save(saveProduct);
	}

	public void deleteById(Long id) {
		
		saveProductRepository.deleteById(id);
	}

	public List<Saveproduct> getAllSavedProductsByCustomerId(Long id) {
		return saveProductRepository.getAllSavedProductsByCustomerId(id);
	}
}
