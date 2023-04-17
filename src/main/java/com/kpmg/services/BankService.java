package com.kpmg.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.kpmg.entities.Account;
import com.kpmg.repositories.AccountRepository;

public interface BankService {

	
	public Account createAccount(Account account) ;
	
	public Account getAccount(int accountId) ;
}
