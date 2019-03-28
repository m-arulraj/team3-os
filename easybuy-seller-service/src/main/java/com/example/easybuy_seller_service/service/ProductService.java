package com.example.easybuy_seller_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easybuy_seller_service.domain.Product;
import com.example.easybuy_seller_service.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	
	public Product save(Product product){
		return productRepository.save(product);
	}


	public Optional<Product> get(Long id) {
		return productRepository.findById(id);
		
	}


	public Product update(Long id,Product product) {
		
		Product p=productRepository.getOne(id);
		p.setName(product.getName());
		p.setPrice(product.getPrice());
		p.setDescription(product.getDescription());
		p.setImage(product.getImage());
		p.setManufacturerfk(product.getManufacturerfk());
		p.setProductcategoryfk(product.getProductcategoryfk());
		
		return productRepository.save(p);
		
	}


	public void delete(Long id) {
		
		productRepository.deleteById(id);
	}
}
