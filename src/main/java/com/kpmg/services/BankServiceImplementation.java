package com.kpmg.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpmg.entities.Account;
import com.kpmg.repositories.AccountRepository;

@Service
public class BankServiceImplementation implements BankService {
	
    @Autowired
	private AccountRepository accountRepository;
	
    
    @Override
    public Account createAccount(Account account) {
    	return accountRepository.save(account);
    }
    
    
    @Override
    public Account getAccount(int accountId) {
    	
    	Optional<Account> opt= accountRepository.findById(accountId);
    	Account account=opt.get();
    	return account;
    }
	
	
}
