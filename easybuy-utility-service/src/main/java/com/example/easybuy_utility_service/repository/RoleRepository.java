package com.example.easybuy_utility_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.easybuy_utility_service.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query("select r from Role r where r.username=:name")
	List<Role> getRolesByUserName(@Param("name") String name);

}
