package com.kpmg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.entities.Transaction;
import com.kpmg.repositories.TransactionRepository;
import com.kpmg.services.TransactionService;

@RequestMapping("/api/transaction")
@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Transaction>> disp(@PathVariable("id") int id)
	{
		List<Transaction> transactions = transactionService.getTransactionsByAccountId(id);
		return ResponseEntity.ok(transactions);
	}
	
	@PostMapping(value="/{id}/newtransaction")
	public ResponseEntity<String> newTransaction(@RequestBody Transaction transaction, @PathVariable("id") int id)
	{
		Transaction tran = new Transaction();
		System.out.println(tran.getTransactionId());
		tran.setAmount(transaction.getAmount());
		tran.setPayeeId(transaction.getPayeeId());
		tran.setPayerId(transaction.getPayerId());
		tran.setTransactionType(transaction.getTransactionType());
		tran.setTransactionDate(transaction.getTransactionDate());
		tran.setRemarks(transaction.getRemarks());
		transactionService.createTransaction(tran,id);
		return ResponseEntity.ok("done");
	}
	
	

}
