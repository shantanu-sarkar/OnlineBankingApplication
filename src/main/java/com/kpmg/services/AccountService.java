package com.kpmg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpmg.entities.Account;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        // Perform any necessary validations
        // Set up initial balance, etc.
        Account newAccount = accountRepository.save(account);
        return newAccount;
    }
}

