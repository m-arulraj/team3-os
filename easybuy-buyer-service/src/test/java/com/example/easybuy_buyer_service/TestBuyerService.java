package com.example.easybuy_buyer_service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.easybuy_buyer_service.controller.BuyerController;
import com.example.easybuy_buyer_service.model.Product;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestBuyerService {

	MockMvc mockMvc;

	@Autowired
	WebApplicationContext webAppContect;

	@InjectMocks
	BuyerController buyerController;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContect).build();
	}

	@Test
	public void testBuyerControllerGetById() throws Exception {

		long id = 2;
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/products/" + id))
				.andExpect(MockMvcResultMatchers.status().isOk());
		String getResponse = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/products/" + id)).andReturn()
				.getResponse().getContentAsString();
		System.out.println(getResponse);

	}

	@Test
	public void testBuyerControllerGetList() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/products"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		String getResponse = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/products")).andReturn()
				.getResponse().getContentAsString();
		System.out.println(getResponse);

	}
	
	@Test
	public void testBuyerControllerProductByCategory() throws Exception {
		String category="Electronix";
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/products/filtered/"+category))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
		String getResponse = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/products/filtered/"+category)).andReturn()
				.getResponse().getContentAsString();
		System.out.println(" *************Filtered**********");
		System.out.println(getResponse);
	}
	
	@Test
	public void testBuyerControllerProductByAscendingPrice() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/products/filtered/Price/"+1))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
