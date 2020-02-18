package com.cg.dto;

public class Account {
	User user;
	private String accountId;
	private double balance;
	private String status;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Account(String accountId, double balance, String status,User user) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.status = status;
		this.user=user;
	}
	

}
