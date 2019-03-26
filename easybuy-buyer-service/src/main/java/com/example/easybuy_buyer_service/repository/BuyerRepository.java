package com.example.easybuy_buyer_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.easybuy_buyer_service.domain.Product;

@Repository
public interface BuyerRepository extends JpaRepository<Product, Long> {

	@Query("select p from Product as p where p.productcategoryfk.name=:category")
	List<Product> getProductByCategory(@Param("category")String category);
	
	@Query("select p from Product as p order by price")
	List<Product> getProductByAscendingPrice();
	
	@Query("select p from Product as p order by price desc")
	List<Product> getProductByDescendingPrice();
}
