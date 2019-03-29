package com.example.easybuy_utility_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.easybuy_utility_service.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

/*	@Query("select u from User u where u.customerfk=:id")
	List<User> getRolesByUsersId(@Param("id") Long id);*/

	@Query("select u from User u where u.username=:name")
	List<User> getUserByName(@Param("name") String name);

}
