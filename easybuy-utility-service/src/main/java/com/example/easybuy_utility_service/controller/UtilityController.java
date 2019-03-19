package com.example.easybuy_utility_service.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.easybuy_utility_service.domain.Registration;
import com.example.easybuy_utility_service.service.UtilityService;

@RestController
public class UtilityController {
	
	@Autowired
	UtilityService utilityService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Registration registration) throws URISyntaxException{
		URI uri=new URI("/get_registred/"+utilityService.register(registration).getId());
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<String>(headers,HttpStatus.CREATED);
	}

	@GetMapping("/get_registred/{id}")
	public Optional<Registration> get(@PathVariable Long id){
		return utilityService.get(id);
	}
}
