package com.example.easybuy_admin_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easybuy_admin_service.domain.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

}
