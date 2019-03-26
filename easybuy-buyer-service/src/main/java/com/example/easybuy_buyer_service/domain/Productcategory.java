package com.example.easybuy_buyer_service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Productcategory {

	@Id
	@GeneratedValue
	long id;
	
	String name;
}
