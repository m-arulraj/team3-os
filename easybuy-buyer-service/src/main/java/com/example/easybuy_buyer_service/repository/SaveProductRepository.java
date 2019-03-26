package com.example.easybuy_buyer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easybuy_buyer_service.model.Cart;

@Repository
public interface SaveProductRepository extends JpaRepository<Cart, Long> {

}
