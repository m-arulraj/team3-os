package com.example.easybuy_admin_service.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easybuy_admin_service.domain.Complaint;
import com.example.easybuy_admin_service.domain.Review;
import com.example.easybuy_admin_service.fegeinproxy.UtilityServiceProxy;
import com.example.easybuy_admin_service.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminResource {

	@Autowired
	AdminService adminService;
	@Autowired
	UtilityServiceProxy utilityServiceProxy;

	@GetMapping(value = "/get_complaint_by_id/{id}")
	public Complaint getByComplaintId(@PathVariable long id) {
		return adminService.getByCompalintId(id);
	}

	@GetMapping(value = "/get_complaint_by_product_id/{id}")
	public void getByProductId(@PathVariable Long id) {

		adminService.getByProductId(id);
	}

	@DeleteMapping(value = "/delete_complaint_by_id/{id}")
	public void deleteComplaintById(@PathVariable Long id) {
		adminService.deleteByComplaintId(id);
	}

	@DeleteMapping(value = "/delete_review_by_id/{id}")
	public void deleteReviewById(@PathVariable Long id) {

		adminService.deleteByReviewId(id);
	}

	@GetMapping(value = "/get_review_by_id/{id}")
	public Optional<Review> getReviewById(@PathVariable Long id) {

		return adminService.getReviewById(id);
	}
	
	@GetMapping(value = "/get_review_by_product_id/{id}")
	public Optional<Complaint> getReviewByProductId(@PathVariable Long id){
		return  adminService.getByProductId(id);
	}
	
	@PutMapping("/update_activation_status/{id}/status/{status}")
	public void updateTheStatus(@PathVariable("id") Long id,@PathVariable("status") String status){
		System.out.println(status);
		//adminService.updateStatus(id,status);
		utilityServiceProxy.updateUserStatus(id, status);
	}
	
}
