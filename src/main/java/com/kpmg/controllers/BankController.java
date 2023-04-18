package com.kpmg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.entities.Account;
import com.kpmg.entities.ServiceRequest;
import com.kpmg.entities.Transaction;
import com.kpmg.entities.User;
import com.kpmg.services.BankService;
import com.kpmg.services.ServiceRequestService;
import com.kpmg.services.UserService;

@RestController
@RequestMapping("/api")
public class BankController {
  
  @Autowired
  private BankService bankService;
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private ServiceRequestService serviceRequestService;
  
  
  @RequestMapping(value="/" ,produces = MediaType.APPLICATION_JSON_VALUE )
  public ResponseEntity<String> home()
  {
	  return ResponseEntity.ok("home");
  }
  
  
  
  @PostMapping("/user")
  public ResponseEntity<User> createUser(@RequestBody User user)
  {
	  User user1 = userService.createUser(user);
	  ServiceRequest serviceRequest = new ServiceRequest();
	  serviceRequest.setUser(user1);
	  serviceRequest.setApproval(false);
	  serviceRequestService.createRequest(serviceRequest);
	  return ResponseEntity.ok(user1);
  }
  
  
  
  
  @PostMapping("/account")
  public ResponseEntity<Account> createAccount(@RequestBody Account account) {
    Account newAccount = bankService.createAccount(account);
    return ResponseEntity.ok(newAccount);
  }
  
  @GetMapping(value="/account/{accountId}")
  public ResponseEntity<Account> getAccount(@PathVariable("accountId") int accountId) {
    Account account = bankService.getAccount(accountId);
    return ResponseEntity.ok(account);
  }
  

}

