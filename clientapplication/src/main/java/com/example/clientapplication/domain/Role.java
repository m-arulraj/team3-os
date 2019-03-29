package com.example.clientapplication.domain;


import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	private long id;
	private String username;
	private String role;

	

	@Override
	public String toString() {
		return "Role [id=" + id + ", username=" + username + ", role=" + role + "]";
	}



	public String getAuthority() {
		return this.role;
	}
}