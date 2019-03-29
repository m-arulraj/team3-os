package com.example.easybuy_admin_service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="complaint")
public class Complaint {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	Long orderfk;
	Long productfk;
	Long customerfk;
}
