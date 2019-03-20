package com.example.easybuy_seller_service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	Long id;
	String name;
	double price;
	String description;
	Byte[] image;
	Long manufacturerfk;
	Long productcategoryfk;
}
