package com.example.easybuy_utility_service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String password;
	String username;
}
