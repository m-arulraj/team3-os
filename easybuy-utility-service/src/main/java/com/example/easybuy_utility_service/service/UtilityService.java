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
	
	public Registration register(Registration registration){
		return utilityRepository.save(registration);
	}

	public Optional<Registration> get(Long id){
		return utilityRepository.findById(id);
	}
}
