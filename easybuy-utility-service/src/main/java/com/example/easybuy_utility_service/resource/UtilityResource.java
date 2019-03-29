package com.example.easybuy_utility_service.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easybuy_utility_service.domain.Registration;
import com.example.easybuy_utility_service.domain.Role;
import com.example.easybuy_utility_service.domain.User;
import com.example.easybuy_utility_service.service.UtilityService;

@RestController
@RequestMapping(value="/api/utility")
public class UtilityResource {
	
	@Autowired
	UtilityService utilityService;
	
	@PostMapping("/register_user")
	public ResponseEntity<String> registerUser(@RequestBody Registration registration) throws URISyntaxException{
		URI uri=new URI("/get_registred/"+utilityService.registerUser(registration).getId());
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<String>(headers,HttpStatus.CREATED);
	}

	@GetMapping("/get_registred/{id}")
	public Optional<Registration> getRegisteredUserById(@PathVariable Long id){
		return utilityService.getRegisteredUserById(id);
	}
	
	@PutMapping(value="/update_status/{id}/status/{status}")
	public Registration updateUserStatus(@PathVariable("id") Long id,@PathVariable("status") String status){
		return utilityService.updateUserStatus(id,status);
	}
	
	@GetMapping("/user/{name}/roles")
	public List<Role> getRoleByName(@PathVariable String name){
		return utilityService.getRolesByUserName(name);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Long id){
		utilityService.removeUser(id);
	}
	
	@GetMapping("/user/{name}")
	public List<User> getUserByName(@PathVariable String name){
		return utilityService.getUserByName(name);
	}
}
