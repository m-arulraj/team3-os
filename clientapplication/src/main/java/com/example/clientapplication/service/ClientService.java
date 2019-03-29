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
		System.out.println("rest issue");
		return responseString;
	}
	
	public String placeOrder(OrderDetails orderDetails){
		System.out.println(orderDetails.getDate());
		String responseString=template.postForObject("http://172.25.229.35:8072/api/products/place_order", orderDetails,String.class);
		System.out.println("place issue");
		return responseString;
	}

	public String saveItem(OrderDetails orderItem) {
		String responseString=template.postForObject("http://172.25.229.35:8072/api/products/save_product", orderItem,String.class);
		return responseString;
	}

	public void removeItemFromCart(long productfk,long customerfk) {
		 template.delete("http://172.25.229.35:8072/api/products/delete_from_cart/"+customerfk+"/product/"+productfk);
	}
}
