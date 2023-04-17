package com.kpmg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.entities.Account;
import com.kpmg.entities.Transaction;
import com.kpmg.services.BankService;

@RestController
@RequestMapping("/api")
public class BankController {
  
  @Autowired
  private BankService bankService;
  
  @PostMapping("/account")
  public ResponseEntity<Account> createAccount(@RequestBody Account account) {
    Account newAccount = bankService.createAccount(account);
    return ResponseEntity.ok(newAccount);
  }
  
  @GetMapping("/account/{accountId}")
  public ResponseEntity<Account> getAccount(@PathVariable int accountId) {
    Account account = bankService.getAccount(accountId);
    return ResponseEntity.ok(account);
  }
  

}

