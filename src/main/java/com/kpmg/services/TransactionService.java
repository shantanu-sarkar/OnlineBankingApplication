package com.kpmg.services;

import java.time.LocalDateTime;
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
		return transactionRepository.findByAccountId(accountId);
	}

	public Transaction createTransaction(Transaction transaction) {

		if (transaction.getTransactionType().equals("WITHDRAW")) {
			Account account = accountRepository.getByAccountId(transaction.getPayeeId());

			if (account != null && account.getBalance() > transaction.getAmount()) {
				account.setBalance(account.getBalance() - transaction.getAmount());
				List<Transaction> temp = account.getTransactions();
				temp.add(transaction);

				accountRepository.save(account);
			} else {
				return null;
			}

		}

		if (transaction.getTransactionType().equals("DEPOSIT")) {
			Account account = accountRepository.getByAccountId(transaction.getPayerId());

			if (account != null) {
				account.setBalance(account.getBalance() + transaction.getAmount());
				List<Transaction> temp = account.getTransactions();
				temp.add(transaction);

				accountRepository.save(account);
			}

		}

		if (transaction.getTransactionType().equals("TRANSFER")) {
			Account payerAccount = accountRepository.getByAccountId(transaction.getPayerId());
			Account payeeAccount = accountRepository.getByAccountId(transaction.getPayeeId());

			if (payerAccount != null && payeeAccount != null && transaction.getAmount() < payerAccount.getBalance())

			{
				payerAccount.setBalance(payerAccount.getBalance() - transaction.getAmount());
				List<Transaction> temp1 = payerAccount.getTransactions();
				temp1.add(transaction);

				payeeAccount.setBalance(payeeAccount.getBalance() + transaction.getAmount());
				List<Transaction> temp2 = payeeAccount.getTransactions();
				temp2.add(transaction);

				accountRepository.save(payerAccount);
				accountRepository.save(payeeAccount);
			}

		}

		return transactionRepository.save(transaction);
	}
}
