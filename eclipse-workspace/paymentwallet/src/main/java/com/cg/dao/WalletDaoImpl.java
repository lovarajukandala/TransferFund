package com.cg.dao;

import com.cg.dto.Account;
import com.cg.dto.Transaction;
import com.cg.exception.AccountIdException;
import com.cg.exception.AmountException;
import com.cg.repo.Repository;

public class WalletDaoImpl implements WalletDao {
	/*************************************************************************************************************
	 * @author LovaRaju
	 * 		Description:The method below returns Account instance if we pass accountId as an argument.If accountId 
	 * 							present in Repository then it returns an account instance.
	 * 
	 * 		Method:The method below returns Account instance if we pass accountId as an argument.If accountId 
	 * 							present in Repository then it returns an account instance.
	 * 		@return Account
	 * 
	 * 		@param accountId:An accountcId is passed and  fetched in the Repository.
	 * 
	 *  	@throws AccountIdException:If the accountId is not available in Repository then AccountIdException is declared.
	 *****************************************************************************************************************
	 */
	public Account getAccountDetails(String accountId) throws AccountIdException {
		if (Repository.map.containsKey(accountId)) {
			Account account = Repository.map.get(accountId);
			return account;
		} else
			throw new AccountIdException("Id does not exist");

	}
	/*************************************************************************************************************
	 * @author LovaRaju
	 * 		Description:The method below returns boolean  if we pass account instance as an argument.It updates the
	 * 						fromAcc balance and toAcc balance.
	 * 
	 * 		Method:The method below returns boolean  if we pass account instance as an argument.It updates the
	 * 						fromAcc balance and toAcc balance.
	 * 		@return Boolean
	 * 
	 * 		@param acc:An Account instance is passed and  gets updated in the Repository.
	 * 
	 *****************************************************************************************************************
	 */

	public boolean updateAmount(Account acc) {
		Repository.map.put(acc.getAccountId(), acc);
		return true;

	}
	/*************************************************************************************************************
	 * @author LovaRaju
	 * 		Description:The method below returns boolean  if we pass Transaction instance as an argument.It adds the
	 * 						transactions as each transfer is successful.
	 * 		Method:The method below returns boolean  if we pass Transaction instance as an argument.It adds the
	 * 						transactions as each transfer is successful.
	 * 
	 * 		@return Boolean
	 * 
	 * 		@param acc:An Transcation instance is passed and  gets added in the Repository.
	 * 
	 *****************************************************************************************************************
	 */
	
	public boolean addTransaction(Transaction txn) {
		Repository.map1.put(txn.getTransactionId(), txn);
			return true;
	}
	
	
}
