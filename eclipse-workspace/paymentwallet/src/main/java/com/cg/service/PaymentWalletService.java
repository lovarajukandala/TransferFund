package com.cg.service;

import com.cg.exception.AccountIdException;
import com.cg.exception.AmountException;

public interface PaymentWalletService {
	
	 boolean transferFund(String fromAccId,String toAccId,double amount)throws AmountException,AccountIdException;	
	 boolean addTransaction();

}
