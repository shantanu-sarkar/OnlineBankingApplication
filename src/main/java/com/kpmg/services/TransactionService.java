package com.kpmg.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpmg.entities.Account;
import com.kpmg.entities.Transaction;
import com.kpmg.repositories.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(int id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction.get();
    }

    public List<Transaction> getTransactionsByAccountId(int accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    public Transaction createTransaction(int payeraccountId, int payeeaccountId,Transaction transaction) {
        Account payeraccount = new Account();
        payeraccount.setAccountId(payeraccountId);
        
        Account payeeaccount = new Account();
        payeeaccount.setAccountId(payeeaccountId);
        
        transaction.setPayee(payeeaccount);
        transaction.setPayer(payeraccount);
        
        transaction.setTransactionDate(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }
}

