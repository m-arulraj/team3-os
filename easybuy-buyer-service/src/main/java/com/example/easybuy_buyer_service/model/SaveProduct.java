package com.example.easybuy_buyer_service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SaveProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;

	Long customerfk;
	Long productfk;
}
