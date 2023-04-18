package com.kpmg.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.kpmg.entities.Account;
import com.kpmg.repositories.AccountRepository;

public class BankService {

	
	   @Autowired
		private AccountRepository accountRepository;
		
	    
	    public Account createAccount(Account account) {
	    	return accountRepository.save(account);
	    }
	    
	    
	    public Account getAccount(int accountId) {
	    	
	    	Optional<Account> opt= accountRepository.findById(accountId);
	    	Account account=opt.get();
	    	return account;
	    }
}
