package com.kpmg.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {

	@Id
	private int transactionId;
	
	private Account payee;
	
	private Account payer;
	
	private double amount;
	
	private LocalDateTime transactionDate;
	
	public Transaction() {
		
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Account getPayee() {
		return payee;
	}

	public void setPayee(Account payee) {
		this.payee = payee;
	}

	public Account getPayer() {
		return payer;
	}

	public void setPayer(Account payer) {
		this.payer = payer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Transaction(int transactionId, Account payee, Account payer, double amount, LocalDateTime transactionDate) {
	
		this.transactionId = transactionId;
		this.payee = payee;
		this.payer = payer;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}


}
