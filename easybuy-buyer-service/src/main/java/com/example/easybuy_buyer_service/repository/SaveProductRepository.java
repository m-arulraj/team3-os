package com.example.easybuy_buyer_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.easybuy_buyer_service.domain.Saveproduct;

@Repository
public interface SaveProductRepository extends JpaRepository<Saveproduct, Long> {

	@Query("select sp from Saveproduct sp where sp.customerfk=:customerfk")
	List<Saveproduct> getAllSavedProductsByCustomerId(@Param("customerfk") Long id);

}
