package com.cg.dto;

import java.time.LocalDate;

public class Transaction {
	Account account;
private int transactionId;
private String description;
private LocalDate dateOfTransaction;
private double amount;
public int getTransactionId() {
	return transactionId;
}
public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public LocalDate getDateOfTransaction() {
	return dateOfTransaction;
}
public void setDateOfTransaction(LocalDate dateOfTransaction) {
	this.dateOfTransaction = dateOfTransaction;
}

public double getAmount() {
	return amount;
}
public void setAmount(float amount) {
	this.amount = amount;
}
public Transaction(int transactionId, String description, LocalDate dateOfTransaction,double amount,Account acc) {
	super();
	this.transactionId = transactionId;
	this.description = description;
	this.dateOfTransaction = dateOfTransaction;
	this.amount = amount;
	this.account=account;
	
}



}
