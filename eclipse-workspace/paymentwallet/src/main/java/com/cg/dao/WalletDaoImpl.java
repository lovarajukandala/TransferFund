package com.cg.dao;

import com.cg.dto.Account;
import com.cg.dto.Transaction;
import com.cg.exception.AccountIdException;
import com.cg.repo.Repository;

public class WalletDaoImpl implements WalletDao {
	public Account getAccountDetails(String accountId) throws AccountIdException {
		if (Repository.map.containsKey(accountId)) {
			Account account = Repository.map.get(accountId);
			return account;
		} else
			throw new AccountIdException("Id does not exist");

	}

	public boolean updateAmount(Account acc) {
		Repository.map.put(acc.getAccountId(), acc);
		return true;

	}

	

	@Override
	public boolean addTransaction(Transaction txn) {
		Repository.map1.put(txn.getTransactionId(), txn);
			return true;
	}
	
	
}
