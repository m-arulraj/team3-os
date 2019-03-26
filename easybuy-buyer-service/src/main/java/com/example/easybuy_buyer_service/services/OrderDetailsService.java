package com.example.easybuy_buyer_service.services;

import org.springframework.stereotype.Service;

import com.example.easybuy_buyer_service.domain.OrderDetails;
import com.example.easybuy_buyer_service.repository.OrderDetailsRepository;

@Service
public class OrderDetailsService {
	
	OrderDetailsRepository orderDetailsRepository;

	public void placeOrder(OrderDetails orderDetails){
		orderDetailsRepository.save(orderDetails);
	}
}
