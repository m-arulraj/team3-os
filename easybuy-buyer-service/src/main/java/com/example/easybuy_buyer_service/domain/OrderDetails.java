package com.example.easybuy_buyer_service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="orderdetails")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String status;
	String date;
	Long customerfk;
	Long productfk;
	
}
