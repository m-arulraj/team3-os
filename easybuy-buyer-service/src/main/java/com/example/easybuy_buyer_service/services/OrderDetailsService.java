package com.example.easybuy_buyer_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easybuy_buyer_service.domain.OrderDetails;
import com.example.easybuy_buyer_service.repository.OrderDetailsRepository;

@Service
public class OrderDetailsService {
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	public void placeOrder(OrderDetails orderDetails){
		System.out.println(orderDetails);
		orderDetailsRepository.save(orderDetails);
	}
}
