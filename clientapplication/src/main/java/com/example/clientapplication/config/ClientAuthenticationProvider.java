package com.example.clientapplication.config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.clientapplication.domain.Role;
import com.example.clientapplication.domain.User;
import com.examplie.clientapplication.util.EndpointConstant;

@Component
public class ClientAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	RestTemplate template;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		System.out.println(username+" done");
		String password = (String) authentication.getCredentials();
		String uri = EndpointConstant.USER_SERVICE_URI+username;
		
		ResponseEntity<List<User>> response = template.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				});
		System.out.println(response.getBody().get(0).getUsername());
		
		User user = response.getBody().get(0);
		if (user == null || !user.getUsername().equalsIgnoreCase(username)) {
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals(user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}
		System.out.println(uri+ "/roles");
		ResponseEntity<List<Role>> roleresponse = template.exchange(uri+ "/roles", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Role>>() {
				});
		
		List<Role> roles = roleresponse.getBody();
		System.out.println(roles.get(0).toString());
		Collection<? extends GrantedAuthority> authorities = roles;
     
		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
}
