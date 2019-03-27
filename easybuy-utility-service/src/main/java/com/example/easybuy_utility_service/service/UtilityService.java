package com.example.easybuy_utility_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easybuy_utility_service.domain.Registration;
import com.example.easybuy_utility_service.repository.UtilityRepository;

@Service
public class UtilityService {
	
	@Autowired
	UtilityRepository utilityRepository;
	
	public Registration registerUser(Registration registration){
		return utilityRepository.save(registration);
	}

	public Optional<Registration> getRegisteredUserById(Long id){
		return utilityRepository.findById(id);
	}

	public Registration updateUserStatus(Long id,String status) {
		Registration registeredUser=null;
		registeredUser=utilityRepository.findById(id).get();
		registeredUser.setStatus(status);
		return utilityRepository.save(registeredUser);
	}
}
