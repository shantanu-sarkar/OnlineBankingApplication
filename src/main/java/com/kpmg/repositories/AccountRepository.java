package com.kpmg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpmg.entities.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {

	Account getByAccountId(int payeeId);

	

}
