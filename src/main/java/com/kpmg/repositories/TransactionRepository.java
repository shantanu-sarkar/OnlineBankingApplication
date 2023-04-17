package com.kpmg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpmg.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findByAccountId(int accountId);

}
