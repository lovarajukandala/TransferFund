package com.cg.service;
import java.time.LocalDate;
import com.cg.dao.WalletDaoImpl;
import com.cg.dto.Account;
import com.cg.dto.Transaction;
import com.cg.exception.AccountIdException;
import com.cg.exception.AmountException;
import com.cg.repo.Repository;
/*************************************************************************************************************
 * @author LovaRaju
 * 		Description:The class PaymentWalletImp implements Interface PaymentWalletService.The logic of transferring 
 * 							amount from fromAccId to toAccId is written in this class.
 * 
 *****************************************************************************************************************
 */

public class PaymentWalletServiceImp implements PaymentWalletService {
	WalletDaoImpl dao = new WalletDaoImpl();
/*************************************************************************************************************
 * @author LovaRaju
 * 		Description:The method below returns true if we transfer amount less than available balance and fromAccId,toAccId
 * 						 are valid arguments present in Repository
 * 
 * 		Method:Transfer amount from fromAccID to toAccId if passed parameters are validated against Repository
 * 
 * 		@return Boolean
 * 
 * 		@param fromAccId:An fromAccId account instance is created and fromAccId is fetched in the Repository.
 * 
 * 		@param toAccId:An toAccId account instance is created and toAccID is fetched in the Repository.
 * 
 * 		@param amount:If the amount to be transferred is less than available available balance,then amount is transferred
 * 							from fromAccId to toAccId.
 * 
 *  	@throws AmountException:If the amount is negative or amount is greater than available balance then AmountException is declared.
 *  
 *  	@throws AccountIdException:If the fromAccId or toAccId are not available in Repository then AccountIdException is declared.
 *****************************************************************************************************************
 */
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
