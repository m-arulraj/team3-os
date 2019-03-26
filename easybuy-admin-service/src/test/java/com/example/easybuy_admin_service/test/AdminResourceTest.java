package com.example.easybuy_admin_service.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.easybuy_admin_service.controller.AdminResource;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AdminResourceTest {

	MockMvc mockMvc;

	@Autowired
	WebApplicationContext webAppContect;

	@InjectMocks
	AdminResource adminResource;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContect).build();
	}

	/*@Test
	public void testAdminController() throws UnsupportedEncodingException, Exception {
		  this.mockMvc
				.perform(MockMvcRequestBuilders.get("/api/admin/get_complaint_by_id/8")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testAdminControllerByProductId() throws UnsupportedEncodingException, Exception {
		 this.mockMvc
				.perform(MockMvcRequestBuilders.get("/api/admin/get_complaint_by_product_id/6")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());


	}

	@Test
	public void testProductControllerForDelete() throws UnsupportedEncodingException, Exception {
	 this.mockMvc
				.perform(MockMvcRequestBuilders.delete("/api/admin/delete_complaint_by_id/2").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	
	}
	
	@Test
	public void testAdminControllerForGetReview() throws UnsupportedEncodingException, Exception {
	this.mockMvc
				.perform(MockMvcRequestBuilders.get("/api/admin/get_review_by_id/3")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	@Test
	public void testAdminControllerForGetReviewByProductId() throws UnsupportedEncodingException, Exception {
	 this.mockMvc
				.perform(MockMvcRequestBuilders.get("/api/admin/get_review_by_product_id/8")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

		
	}
	
	@Test
	public void testProductControllerForDeleteReview() throws UnsupportedEncodingException, Exception {
		 this.mockMvc
				.perform(MockMvcRequestBuilders.delete("/api/admin/delete_review_by_id/2")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	
	}
	*/
	@Test
	public void testAdminControllerForUpdatingStatus() throws Exception{
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/updating_activation_status/3/approved")
				.contentType(MediaType.APPLICATION_JSON));
				
		
	}
	
}
