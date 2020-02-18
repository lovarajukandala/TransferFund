package com.cg.exception;

public class AmountException extends Exception{
public  AmountException()
{
}
public  AmountException(String message)
{
	System.err.println(message);
}

}
