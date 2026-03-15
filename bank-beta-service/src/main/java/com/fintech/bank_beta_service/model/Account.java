package com.fintech.bank_beta_service.model;

public class Account {

	private String accountId;
	private String bank;
	private double balance;

	public Account(String accountId, String bank, double balance) {
		this.accountId = accountId;
		this.bank = bank;
		this.balance = balance;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getBank() {
		return bank;
	}

	public double getBalance() {
		return balance;
	}
}
