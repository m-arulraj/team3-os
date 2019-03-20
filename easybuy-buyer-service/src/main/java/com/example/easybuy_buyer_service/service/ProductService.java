package com.example.easybuy_buyer_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easybuy_buyer_service.domain.Product;
import com.example.easybuy_buyer_service.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public Optional<Product> get(Long id) {

		return productRepository.findById(id);
	}
	
	public void delete(Long id){
		productRepository.deleteById(id);
	}

	public Product update(Long id,Product produ) {
		
		 Product product=productRepository.getOne(id);
		 product.setName(produ.getName());
		 product.setPrice(produ.getPrice());
		 product.setDescription(produ.getDescription());
		 product.setImage(produ.getImage());
		 product.setManufacturerfk(produ.getManufacturerfk());
		 product.setProductcategoryfk(produ.getProductcategoryfk());
		 
		 return productRepository.save(product);
		 
		
	}
}
