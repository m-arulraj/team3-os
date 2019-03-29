package com.example.easybuy_buyer_service.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.easybuy_buyer_service.domain.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query("SELECT c from Cart c where c.customerfk =:id")
	List<Cart> getAllCartProductsByCustomerId(@Param("id") Long id);

	@Transactional
	@Modifying
	@Query ("delete from Cart where productfk=:productfk and customerfk=:customerfk")
	void deleteFromCartByProductId(@Param("customerfk") Long customerfk,@Param("productfk") Long productfk);


	
	

}
