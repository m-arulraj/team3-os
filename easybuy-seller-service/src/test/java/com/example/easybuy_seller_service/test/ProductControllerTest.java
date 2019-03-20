package com.example.easybuy_seller_service.test;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.easybuy_seller_service.controller.ProductController;
import com.example.easybuy_seller_service.domain.Product;
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
	public void setup(){
		this.mockMvc=MockMvcBuilders.webAppContextSetup(webAppContect).build();
	}
	
	
	@Test
	public void testProductController() throws Exception{
		Product product=new Product();
		product.setName("34 inches LEDTV");
		product.setPrice(588.25);
		product.setImage(null);
		product.setDescription("goodProduct with 4 years warrenty");
		product.setManufacturerfk(3l);
		product.setProductcategoryfk(2l);
		String saveUri=this.mockMvc.perform(MockMvcRequestBuilders.post("/save_product")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(product)))
				.andExpect(MockMvcResultMatchers.status().isCreated()).andReturn().getResponse().getHeader("Location").toString();
		System.out.println("saveUri "+saveUri);
		String reg;
		reg=this.mockMvc.perform(MockMvcRequestBuilders.get("/get_product/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		System.out.println("reg "+reg);
		
	}
	
	@Test
	public void testProductControllerForDelete() throws UnsupportedEncodingException, Exception{
		ResultActions reg;
		reg=this.mockMvc.perform(MockMvcRequestBuilders.delete("/delete_product/9").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
		System.out.println("reg "+reg);
	}
	
	
	@Test
	public void testProductControllerForUpdate() throws Exception{
		Product product=new Product();
		product.setName("52 inches LEDTV");
		product.setPrice(45588.25);
		product.setImage(null);
		product.setDescription("goodProduct with 4 years warrenty");
		product.setManufacturerfk(3l);
		product.setProductcategoryfk(2l);
		String saveUri=this.mockMvc.perform(MockMvcRequestBuilders.patch("/update_product/13")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(product)))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getHeader("Location").toString();
		System.out.println("saveUri "+saveUri);
		/*String reg;
		reg=this.mockMvc.perform(MockMvcRequestBuilders.get("/get_product/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		System.out.println("reg "+reg);
		*/
	}
}
