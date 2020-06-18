package com.saimetta.cloudnativejava.chapter4.demo.account;

public class Account {
	private String name;
	private AccountNumber accountNumber;
	
	public Account(String name, AccountNumber accountNumber) {
		super();
		this.name = name;
		this.accountNumber = accountNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AccountNumber getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(AccountNumber accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}
