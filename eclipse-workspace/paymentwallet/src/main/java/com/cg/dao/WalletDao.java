package com.cg.dao;

import com.cg.dto.Account;
import com.cg.dto.Transaction;
import com.cg.exception.AccountIdException;

public interface WalletDao {

	 Account getAccountDetails(String accountId) throws AccountIdException;
	 boolean updateAmount(Account account1);
	 boolean addTransaction(Transaction txn);
	 

	
}
