package com.capgemini.paymentwallet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;

import com.cg.exception.AccountIdException;
import com.cg.exception.AmountException;
import com.cg.service.PaymentWalletService;
import com.cg.service.PaymentWalletServiceImp;

public class PaymentWalletTest {
	@DisplayName("Transferring fund")
	@Test
	public void paymentWalletTest1() throws AmountException, AccountIdException
	{
		PaymentWalletService ser=new PaymentWalletServiceImp();
		assertEquals(true, ser.transferFund("12345841545", "12245841565", 1000));
	}
	@DisplayName("Wrong toAccId")
	@Test
	public void paymentWalletTest2()
	{
		PaymentWalletService ser=new PaymentWalletServiceImp();
		assertThrows(AccountIdException.class,
				()->ser.transferFund("12345841545", "15151", 500));
		
	}
	@DisplayName("Wrong fromAccId")
	@Test
	public void paymentWalletTest3()
	{
		PaymentWalletService ser=new PaymentWalletServiceImp();
		assertThrows(AccountIdException.class,
				()->ser.transferFund("12481", "12345841545", 500));
		
	}
	@DisplayName("Amount Negative")
	@Test
	public void paymentWalletTest4()
	{
		PaymentWalletService ser=new PaymentWalletServiceImp();
		assertThrows(AmountException.class,
				()->ser.transferFund("12345841545", "12345841545", -500));
		
	}
	@DisplayName("Amount greater than available balance")
	@Test
	public void paymentWalletTest5()
	{
		PaymentWalletService ser=new PaymentWalletServiceImp();
		assertThrows(AmountException.class,
				()->ser.transferFund("12345841545", "12345841545", 2500));
		
	}
	
	
	

}
