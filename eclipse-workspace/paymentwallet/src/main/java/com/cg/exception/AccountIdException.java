package com.cg.exception;

public class AccountIdException extends Exception {
	public AccountIdException() {
		
	}
public AccountIdException(String message) {
		System.err.println(message);
	}
	
}
