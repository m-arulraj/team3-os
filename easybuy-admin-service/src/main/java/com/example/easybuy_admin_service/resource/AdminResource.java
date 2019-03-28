package com.example.easybuy_admin_service.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easybuy_admin_service.domain.Complaint;
import com.example.easybuy_admin_service.domain.Review;
import com.example.easybuy_admin_service.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminResource {

	@Autowired
	AdminService adminService;
	
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
	
	@PostMapping("/add_complaint")
	public ResponseEntity<String> addComplaint(@RequestBody Complaint complaint) throws URISyntaxException{
		URI uri=new URI("/get_registred/"+adminService.addComplaint(complaint).getId());
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<String>(headers,HttpStatus.CREATED);
	}
	
	@PostMapping("/add_review")
	public ResponseEntity<String> addReview (@RequestBody Review review) throws URISyntaxException{
		URI uri=new URI("/get_registred/"+adminService.addReview(review).getId());
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<String>(headers,HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/update_review/{id}/ratings/{rating}")

	public HttpStatus UpdateReview(@PathVariable Long id,@PathVariable int rating){
		adminService.updateReview( id, rating);
		return HttpStatus.OK;
	}
}
