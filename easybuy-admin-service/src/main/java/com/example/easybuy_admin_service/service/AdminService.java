package com.example.easybuy_admin_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.easybuy_admin_service.domain.Complaint;
import com.example.easybuy_admin_service.domain.Review;
import com.example.easybuy_admin_service.repository.ComplaintRepository;
import com.example.easybuy_admin_service.repository.ReviewRepository;

@Service
public class AdminService {

	@Autowired
	ComplaintRepository complaintRepository;

	@Autowired
	ReviewRepository reviewRepository;
	

	public Complaint getByCompalintId(Long id) {
		return complaintRepository.getOne(id);
	}

	public Optional<Complaint> getByProductId(Long productId) {
		return complaintRepository.findById(productId);
	}

	public void deleteByComplaintId(long id) {
		complaintRepository.deleteById(id);
	}

	public Optional<Review> getReviewById(Long id) {

		return reviewRepository.findById(id);
	}

	public Optional<Review> getReviewByProductId(Long id){
		return reviewRepository.findById(id);
	}
	
	public void deleteByReviewId(Long id) {

		reviewRepository.deleteById(id);
	}

	public void updateStatus(Long id,String status) {
		
		
		
	}
}
