package com.example.easybuy_buyer_service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="saveproduct")
public class Saveproduct {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;

	Long customerfk;
	Long productfk;
}
