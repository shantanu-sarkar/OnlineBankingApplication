package com.kpmg.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Account {

	@Id
	private int accountId;
	
	
	private User user;
	
	
	private List<Transaction> transactions;
	
	private double balance;
	
	
	
	public int getAccountId() {
		return accountId;
	}



	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<Transaction> getTransactions() {
		return transactions;
	}



	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public Account() {
		// TODO Auto-generated constructor stub
	}



	public Account(int accountId, User user, List<Transaction> transactions, double balance) {
		
		this.accountId = accountId;
		this.user = user;
		this.transactions = transactions;
		this.balance = balance;
	}
	
	
	
}
