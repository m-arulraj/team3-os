package com.example.easybuy_utility_service.test;

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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.easybuy_utility_service.domain.Registration;
import com.example.easybuy_utility_service.resource.UtilityResource;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UtilityControllerTest {
	
	MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext webAppContect;
	
	@InjectMocks
	UtilityResource utilityController;
	
	@Before
	public void setup(){
		this.mockMvc=MockMvcBuilders.webAppContextSetup(webAppContect).build();
	}
	
	//@Test
	public void testUtilityController() throws Exception{
		Registration registration=new Registration();
		registration.setName("vamsi");
		registration.setEmail("pawan@gmail.com");
		registration.setCityfk(1);
		registration.setType("B");
		registration.setMobile("+91888888888");
		registration.setImage(null);
		registration.setRegistrationdate("2001-08-23");
		registration.setStatus("Waiting");
		String saveUri=this.mockMvc.perform(MockMvcRequestBuilders.post("/api/admin/register_user")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(registration)))
				.andExpect(MockMvcResultMatchers.status().isCreated()).andReturn().getResponse().getHeader("Location").toString();
		System.out.println(saveUri);
		String reg;
		reg=this.mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/get_registred/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		System.out.println(reg);
	}
	
	@Test
	public void testUtilityControllerForUpdation() throws Exception{
		ResultActions updateUri= this.mockMvc.perform(MockMvcRequestBuilders.put("/api/admin/update_status/1/status/Activated")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
