package com.example.easybuy_utility_service.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easybuy_utility_service.domain.Registration;
import com.example.easybuy_utility_service.domain.Role;
import com.example.easybuy_utility_service.domain.User;
import com.example.easybuy_utility_service.repository.RoleRepository;
import com.example.easybuy_utility_service.repository.UserRepository;
import com.example.easybuy_utility_service.repository.UtilityRepository;

@Service
public class UtilityService {
	
	@Autowired
	UtilityRepository utilityRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Transactional
	public Registration registerUser(Registration registration){
		User user = new User();
		Role role=new Role();
		user.setUsername(registration.getEmail());
		user.setPassword(registration.getPassword());
		role.setUsername(registration.getEmail());
		if(registration.getType().equalsIgnoreCase("B"))
			role.setRole("ROLE_USER");
		else
			role.setRole("ROLE_SELLER");
		saveRole(role);
		saveUser(user);
		return utilityRepository.save(registration);
	}

	private void saveRole(Role role) {
		roleRepository.save(role);	
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
	
	public void saveUser(User user){
		userRepository.save(user);
	}
	
	public List<User> getUserByName(String name){
		return userRepository.getUserByName(name);
	}
	
	public void removeUser(Long id){
		userRepository.deleteById(id);
	}


	public List<Role> getRolesByUserName(String name) {
		return roleRepository.getRolesByUserName(name);
	}
	
}
