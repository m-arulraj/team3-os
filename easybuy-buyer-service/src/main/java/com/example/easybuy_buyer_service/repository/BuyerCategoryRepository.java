package com.example.easybuy_buyer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.easybuy_buyer_service.domain.Productcategory;

public interface BuyerCategoryRepository extends JpaRepository<Productcategory, Long> {

}
