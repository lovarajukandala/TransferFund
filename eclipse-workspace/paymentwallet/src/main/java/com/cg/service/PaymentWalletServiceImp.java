package com.cg.service;
import java.time.LocalDate;

import com.cg.dao.WalletDaoImpl;
import com.cg.dto.Account;
import com.cg.dto.Transaction;
import com.cg.exception.AccountIdException;
import com.cg.exception.AmountException;
import com.cg.repo.Repository;

public class PaymentWalletServiceImp implements PaymentWalletService {
	WalletDaoImpl dao = new WalletDaoImpl();

	public boolean transferFund(String fromAccId,String toAccId,double amount) throws AmountException, AccountIdException
	{
		if(amount<0)
			throw new AmountException("Amount cannot be negative");		
		Account fromAcc = dao.getAccountDetails(fromAccId);
		Account toAcc = dao.getAccountDetails(toAccId);
		if(amount > fromAcc.getBalance())
			throw new AmountException("Amount should be less than available balance");
		if(amount<=fromAcc.getBalance())
		{
			fromAcc.setBalance(fromAcc.getBalance()-amount);
			toAcc.setBalance(toAcc.getBalance()+amount);
			dao.updateAmount(fromAcc);
			dao.updateAmount(toAcc);
			dao.addTransaction(new Transaction(++Repository.tid,"Transfer", LocalDate.now(),amount,fromAcc));
			dao.addTransaction(new Transaction(++Repository.tid,"Transfer", LocalDate.now(),amount,toAcc));
			return true;
		}
		return false;
			
	}

	@Override
	public boolean addTransaction() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
