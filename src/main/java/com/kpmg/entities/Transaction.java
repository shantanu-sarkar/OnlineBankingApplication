package com.kpmg.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	private int transactionId;
	
	
	private int payerId;
	
	private int payeeId;
	
	private double amount;
	
	private LocalDateTime transactionDate;
	
	private TransactionType transactionType;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getPayerId() {
		return payerId;
	}

	public void setPayerId(int payerId) {
		this.payerId = payerId;
	}

	public int getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(int payeeId) {
		this.payeeId = payeeId;
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
	

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Transaction(int transactionId, int payerId, int payeeId, double amount, LocalDateTime transactionDate,
			TransactionType transactionType) {
		super();
		this.transactionId = transactionId;
		this.payerId = payerId;
		this.payeeId = payeeId;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
	}

	
	
	

}
