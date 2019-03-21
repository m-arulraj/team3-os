package com.example.easybuy_buyer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.easybuy_buyer_service.model.ProductCategory;

public interface BuyerCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
