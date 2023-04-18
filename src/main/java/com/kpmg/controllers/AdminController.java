package com.kpmg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.entities.Account;
import com.kpmg.entities.ServiceRequest;
import com.kpmg.entities.User;
import com.kpmg.entities.User;
import com.kpmg.repositories.ServiceRequestRepository;
import com.kpmg.services.AccountService;
import com.kpmg.services.ServiceRequestService;
import com.kpmg.services.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	ServiceRequestService requestService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;
	
	
	@GetMapping(value="/servicerequests" ,produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServiceRequest>> view()
	{
		List<ServiceRequest> requests = requestService.getRequests();
		return ResponseEntity.ok(requests);
	}
	
	@DeleteMapping(value="/servicerequests/{id}")
	public ResponseEntity<String> deleterequest(@PathVariable("id") int id)
	{
		
		 requestService.deleteRequest(id);
		 return ResponseEntity.ok("Deleted");
	}
	
	@GetMapping(value="/servicerequests/{id}")
	public ResponseEntity<String> acceptrequest(@PathVariable("id") int id)
	{
		ServiceRequest req =requestService.getRequest(id);
		Account account = new Account();
		Account account1 =accountService.createAccount(account);
		System.out.println(account1.getAccountId());
		User user =req.getUser();
		user.setAccount(account1);
		System.out.println(user.getAccount());
		userService.createUser(user);
		requestService.deleteRequest(id);
		return ResponseEntity.ok("Approved");
		
	}
	
	
	

}
