package com.example.easybuy_admin_service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import com.example.easybuy_admin_service.domain.Complaint;
import com.example.easybuy_admin_service.domain.Review;
import com.example.easybuy_admin_service.service.AdminService;

@Controller
public class AdminResource {

	@Autowired
	AdminService adminService;

	@GetMapping(value = "/api/admin/get_complaint_by_id/{id}")
	public Complaint getByComplaintId(@PathVariable long id) {
		return adminService.getByCompalintId(id);
	}

	@GetMapping(value = "/api/admin/get_complaint_by_product_id/{id}")
	public void getByProductId(@PathVariable Long id) {

		adminService.getByProductId(id);
	}

	@DeleteMapping(value = "/api/admin/delete_complaint_by_id/{id}")
	public void deleteComplaintById(@PathVariable Long id) {
		adminService.deleteByComplaintId(id);
	}

	@DeleteMapping(value = "/api/admin/delete_review_by_id/{id}")
	public void deleteReviewById(@PathVariable Long id) {

		adminService.deleteByReviewId(id);
	}

	@GetMapping(value = "/api/admin/get_review_by_id/{id}")
	public Optional<Review> getReviewById(@PathVariable Long id) {

		return adminService.getReviewById(id);
	}
	
	@GetMapping(value = "/api/admin/get_review_by_product_id/{id}")
	public Optional<Complaint> getReviewByProductId(@PathVariable Long id){
		return  adminService.getByProductId(id);
	}
	
	@PostMapping("/api/admin/updating_activation_status/{id}")
	public void updateTheStatus(@PathVariable Long id,@PathVariable String status){
		System.out.println(status);
		adminService.updateStatus(id,status);
	}
	
}
