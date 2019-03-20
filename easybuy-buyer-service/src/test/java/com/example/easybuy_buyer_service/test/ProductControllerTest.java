package com.example.easybuy_buyer_service.test;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.easybuy_buyer_service.controller.ProductController;
import com.example.easybuy_buyer_service.domain.Product;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductControllerTest {

	MockMvc mockMvc;

	@Autowired
	WebApplicationContext webAppContect;

	@InjectMocks
	ProductController productController;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContect).build();
	}

	String saveUri = null;

	/* TEST CASE FOR SAVE AND GET */
	@Test
	public void testProductController() throws Exception {
		Product product = new Product();
		product.setName("Wrist Watch");
		product.setPrice(7999.00);
		product.setDescription("1 year warrenty");
		product.setImage(null);
		product.setProductcategoryfk(2l);
		product.setManufacturerfk(6l);
		saveUri = this.mockMvc
				.perform(MockMvcRequestBuilders.post("/save_product").contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(product)))
				.andExpect(MockMvcResultMatchers.status().isCreated()).andReturn().getResponse().getHeader("Location")
				.toString();
		// System.out.println("saveuri " + saveUri);
		String reg;
		reg = this.mockMvc.perform(MockMvcRequestBuilders.get(saveUri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		System.out.println("reg " + reg);
	}

	 /*TEST CASE FOR DELETE */
	@Test
	public void testProductControllerForDelete() throws Exception {

		ResultActions res = this.mockMvc
				.perform(MockMvcRequestBuilders.delete("/delete_product/5").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/* TEST CASE FOR UPDATE */
	@Test
	public void testProductControllerForUpdate() throws Exception {
		Product product = new Product();
		product.setName("MI earphones");
		product.setPrice(699.00);
		product.setDescription("Stylish Look");
		product.setImage(null);
		product.setProductcategoryfk(2l);
		product.setManufacturerfk(4l);
		saveUri = this.mockMvc
				.perform(MockMvcRequestBuilders.patch("/update_product/3").contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(product)))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getHeader("Location")
				.toString();
		System.out.println("saveuri " + saveUri);
		String reg;
		reg = this.mockMvc.perform(MockMvcRequestBuilders.get(saveUri).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		System.out.println("reg " + reg);
	}

}
