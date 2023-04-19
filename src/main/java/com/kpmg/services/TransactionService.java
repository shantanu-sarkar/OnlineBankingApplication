package com.kpmg.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpmg.entities.Account;
import com.kpmg.entities.Transaction;
import com.kpmg.entities.TransactionType;
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

	public Transaction createTransaction(Transaction transaction,int id){

		if (transaction.getTransactionType().equals("WITHDRAW")) {
			Account account = accountRepository.findById(transaction.getPayeeId()).get();

			if (account != null && account.getBalance() > transaction.getAmount() && transaction.getPayeeId() == id) {
				account.setBalance(account.getBalance() - transaction.getAmount());
				List<Transaction> temp = account.getTransactions();
				temp.add(transaction);

				accountRepository.save(account);
			} else {
				return null;
			}

		}

		if (transaction.getTransactionType().equals("DEPOSIT")) {
			Account account = accountRepository.findById(transaction.getPayerId()).get();
//TODO : MAKE DIFFERENT PATHWAYS ACCORDING TO DIFFERENT ERRORS SUCH AS ID NOT MATCHING OR ID NOT FOUND OE ETC
			if (account != null && transaction.getPayerId()== id) {
				account.setBalance(account.getBalance() + transaction.getAmount());
				List<Transaction> temp = account.getTransactions();
				temp.add(transaction);

				accountRepository.save(account);
			}

		}

		if (transaction.getTransactionType().equals("TRANSFER")) {
			
			Account payerAccount = accountRepository.findById(transaction.getPayerId()).get();
			Account payeeAccount = accountRepository.findById(transaction.getPayeeId()).get();

			if (payerAccount != null && payeeAccount != null && transaction.getAmount() < payerAccount.getBalance())

			{
				Account payer = accountRepository.findById(payerAccount.getAccountId()).get();
				payer.setBalance(payerAccount.getBalance() - transaction.getAmount());
				List<Transaction> temp1 = payer.getTransactions();
				temp1.add(transaction);
				payer.setTransactions(temp1);
				Account payee = accountRepository.findById(payeeAccount.getAccountId()).get();
				payee.setBalance(payeeAccount.getBalance() + transaction.getAmount());
				List<Transaction> temp2 = payee.getTransactions();
				temp2.add(transaction);
				payee.setTransactions(temp2);
				
				accountRepository.save(payer);
				accountRepository.save(payee);
			}

		}

		return transactionRepository.save(transaction);
	}
}
