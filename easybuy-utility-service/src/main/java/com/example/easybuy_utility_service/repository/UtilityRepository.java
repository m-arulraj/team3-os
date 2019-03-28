package com.example.easybuy_utility_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easybuy_utility_service.domain.Registration;

@Repository
public interface UtilityRepository extends JpaRepository<Registration, Long>{

}
