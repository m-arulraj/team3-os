package com.example.easybuy_buyer_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ProductCategory {

	@Id
	@GeneratedValue
	long id;
	
	String name;
}
