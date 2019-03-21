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

import com.example.easybuy_seller_service.controller.ProductResource;
import com.example.easybuy_seller_service.domain.Product;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductResourceTest {

	MockMvc mockMvc;

	@Autowired
	WebApplicationContext webAppContect;

	@InjectMocks
	ProductResource productResource;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContect).build();
	}

	/*@Test
	public void testProductResource() throws Exception {
		Product product = new Product();
		product.setName("34 inches LEDTV");
		product.setPrice(588.25);
		product.setImage(null);
		product.setDescription("goodProduct with 4 years warrenty");
		product.setManufacturerfk(3l);
		product.setProductcategoryfk(2l);
		String saveUri = this.mockMvc
				.perform(MockMvcRequestBuilders.post("/api/seller/save_product").contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(product)))
				.andExpect(MockMvcResultMatchers.status().isCreated()).andReturn().getResponse().getHeader("Location")
				.toString();
		System.out.println("saveUri " + saveUri);
		String reg;
		reg = this.mockMvc.perform(MockMvcRequestBuilders.get("/ap1/seller/get_product/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		System.out.println("reg " + reg);

	}*/

	/*@Test
	public void testProductControllerForDelete() throws UnsupportedEncodingException, Exception {
		ResultActions reg;
		reg = this.mockMvc
				.perform(MockMvcRequestBuilders.delete("/api/seller/delete_product/9").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
		System.out.println("reg " + reg);
	}
*/
	@Test
	public void testProductControllerForUpdate() throws Exception {
		Product product = new Product();
		product.setName("51 inches LEDTV");
		product.setPrice(45588.25);
		product.setImage(null);
		product.setDescription("goodProduct with 4 years warrenty");
		product.setManufacturerfk(3l);
		product.setProductcategoryfk(2l);
		String saveUri = this.mockMvc
				.perform(MockMvcRequestBuilders.patch("/api/seller/update_product/13").contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(product)))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getHeader("Location")
				.toString();
		System.out.println("saveUri " + saveUri);
		String reg;
		reg = this.mockMvc
				.perform(MockMvcRequestBuilders.get("/ap1/seller/get_product/10").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		System.out.println("reg " + reg);

	}
}
