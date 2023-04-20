package com.kpmg.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpmg.entities.Account;
import com.kpmg.entities.Transaction;
import com.kpmg.repositories.AccountRepository;
import com.kpmg.repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountRepository accountRepository;

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public Transaction getTransactionById(int id) {
		Optional<Transaction> transaction = transactionRepository.findById(id);
		return transaction.get();
	}

	public List<Transaction> getTransactionsByAccountId(int accountId) {
		return transactionRepository.findByPayerIdOrPayeeId(accountId,accountId);
	}

	public void createTransaction(Transaction transaction,int id){

		if (transaction.getTransactionType().equals("WITHDRAW")) {
			Account account = accountRepository.findById(transaction.getPayeeId()).get();

			if (account != null && account.getBalance() > transaction.getAmount() && transaction.getPayeeId() == id) {
				account.setBalance(account.getBalance() - transaction.getAmount());
				List<Transaction> temp = account.getTransactions();
				temp.add(transaction);
				transactionRepository.save(transaction);
				accountRepository.save(account);
			} 

		}

		if (transaction.getTransactionType().equals("DEPOSIT")) {
			Account account = accountRepository.findById(transaction.getPayerId()).get();
//TODO : MAKE DIFFERENT PATHWAYS ACCORDING TO DIFFERENT ERRORS SUCH AS ID NOT MATCHING OR ID NOT FOUND OE ETC
			if (account != null && transaction.getPayerId()== id) {
				account.setBalance(account.getBalance() + transaction.getAmount());
				List<Transaction> temp = account.getTransactions();
				temp.add(transaction);
				transactionRepository.save(transaction);
				accountRepository.save(account);
				
			}

		}

		if (transaction.getTransactionType().equals("TRANSFER")) {
			
			Account payerAccount = accountRepository.findById(transaction.getPayerId()).get();
			Account payeeAccount = accountRepository.findById(transaction.getPayeeId()).get();

			if (payerAccount != null && payeeAccount != null && transaction.getAmount() < payerAccount.getBalance())

			{
				
				payerAccount.setBalance(payerAccount.getBalance() - transaction.getAmount());
				List<Transaction> temp1 = payerAccount.getTransactions();
				temp1.add(transaction);
				payerAccount.setTransactions(temp1);
				payeeAccount.setBalance(payeeAccount.getBalance() + transaction.getAmount());
				List<Transaction> temp2 = payeeAccount.getTransactions();
				temp2.add(transaction);
				payeeAccount.setTransactions(temp2);
				transactionRepository.save(transaction);
				accountRepository.save(payerAccount);
				accountRepository.save(payeeAccount);
			
			}
			

		}

		
	}
}
