package com.example.easybuy_utility_service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="REGISTRATION")
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String email;
	int cityfk;
	String mobile;
	String registrationdate;
	String type;
	Byte [] image;
	String status;
}
