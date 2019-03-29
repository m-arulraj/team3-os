package com.example.clientapplication.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.clientapplication.domain.Cart;
import com.example.clientapplication.domain.OrderDetails;

@Service
public class ClientService {

	RestTemplate template=new RestTemplate();
	public String addToCart(Cart cart){
		/*template.exchange("172.25.229.35:8072/api/products/add_to_cart", RequestMethod.POST,cart,new ParameterizedTypeReference<Cart>() {
		});*/
		//template.exchange("172.25.229.35:8072/api/products/add_to_cart", RequestMethod.POST, cart, Long.class);
		String responseString=template.postForObject("http://172.25.229.35:8072/api/products/add_to_cart", cart,String.class);
		return responseString;
	}
	
	public String placeOrder(OrderDetails orderDetails){
		System.out.println(orderDetails.getDate());
		String responseString=template.postForObject("http://172.25.229.35:8072/api/products/place_order", orderDetails,String.class);
		return responseString;
	}
}
