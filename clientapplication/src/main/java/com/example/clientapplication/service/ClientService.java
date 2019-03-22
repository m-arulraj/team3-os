package com.example.clientapplication.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.clientapplication.domain.Product;
import com.example.clientapplication.util.EndpointConstant;


@Service
public class ClientService {
	
	RestTemplate template=new RestTemplate();
	
	public List<Product> getAllProduct(){
		System.out.println("start");
		ResponseEntity<List<Product>> response = template.exchange(EndpointConstant.BUYER_SERVICE_URI,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
				});
		System.out.println("end");
		return response.getBody();
	}

}
