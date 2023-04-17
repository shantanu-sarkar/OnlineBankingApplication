package com.kpmg.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {

	@Id
	private int transactionId;
	
	private User payee;
	
	private User payer;
	
	private double amount;
	
	private LocalDateTime timeOfTransaction;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
}
