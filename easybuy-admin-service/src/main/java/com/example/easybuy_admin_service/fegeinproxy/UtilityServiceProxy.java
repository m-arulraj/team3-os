package com.example.easybuy_admin_service.fegeinproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.easybuy_admin_service.domain.Registration;


@FeignClient(value="utility-service",path="/api/utility")
public interface UtilityServiceProxy {
	
	@PutMapping(value="/update_status/{id}/status/{status}")
	public Registration updateUserStatus(@PathVariable("id") Long id,@PathVariable("status") String status);
}
