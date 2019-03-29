
package com.example.easybuy_admin_service.test;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.easybuy_admin_service.domain.Complaint;
import com.example.easybuy_admin_service.domain.Review;
import com.example.easybuy_admin_service.resource.AdminResource;
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

	@Test
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
	
	@Test
	public void testAdminControllerForUpdatingStatus() throws Exception{
		
		this.mockMvc.perform(MockMvcRequestBuilders.put("/api/admin/update_activation_status/3/status/approved")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
				
		
	}
	

	@Test
	public void testAdminControllerForAddComplaint() throws Exception{
		Complaint complaint=new Complaint();
		complaint.setCustomerfk(1l);
		complaint.setProductfk(1l);
		complaint.setOrderfk(1l);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/add_complaint")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(complaint)))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	@Test
	public void testAdminControllerForAddReview() throws Exception{
		Review review=new Review();
		
		review.setCustomerfk(1l);
		review.setProductfk(1l);
		review.setOrderfk(1l);
		review.setRattings(3);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/add_review")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(review)))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void updateReview() throws Exception{
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/update_review/3/ratings/5")).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
