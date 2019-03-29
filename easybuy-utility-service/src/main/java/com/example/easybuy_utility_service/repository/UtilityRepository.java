package com.example.easybuy_utility_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.easybuy_utility_service.domain.Registration;

@Repository
public interface UtilityRepository extends JpaRepository<Registration, Long>{

	@Query("Select r.name from Registration r where r.id=:customerfk")
	String getNameById(@Param("customerfk") Long customerfk);

}
