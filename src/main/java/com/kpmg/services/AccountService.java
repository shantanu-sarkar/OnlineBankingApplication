package com.kpmg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpmg.entities.Account;
import com.kpmg.repositories.AccountRepository;

@Service
public class AccountService
{  
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        
        Account newAccount = accountRepository.save(account);
        return newAccount;
    }
}

