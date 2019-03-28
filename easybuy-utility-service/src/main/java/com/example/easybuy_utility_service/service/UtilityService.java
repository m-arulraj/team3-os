package com.example.easybuy_utility_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	public void saveUser(User user){
		userRepository.save(user);
	}
	
	public User getUserById(Long id){
		return userRepository.getOne(id);
	}
	
	public void removeUser(Long id){
		userRepository.deleteById(id);
	}

	public List<Role> getRolesByUserId(Long id) {
		List<Role> roles=new ArrayList<Role>();
		List<User> users = userRepository.getRolesByUsersId(id);
		System.out.println("got users");
		users.forEach(user->roles.add(roleRepository.getOne(user.getRolefk())));
		return roles;
	}
	
}
