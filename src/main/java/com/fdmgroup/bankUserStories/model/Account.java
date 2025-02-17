package com.fdmgroup.bankUserStories.model;

public abstract class Account {
	
	private final long ACCOUNT_ID;
	private static long nextAccountId;
	protected double balance;
	
	protected Account() {
		ACCOUNT_ID = 1000 + nextAccountId;
		nextAccountId += 5;
	}
	
	public double withdraw(double amount) {
		return this.balance -= amount;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void correctBalance(double amount) {
		this.balance = amount;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public static long getNextAccountId() {
		return Account.nextAccountId;
	}

	public static void setNextAccountId(long nextAccountId) {
		Account.nextAccountId = nextAccountId;
	}

	public long getACCOUNT_ID() {
		return this.ACCOUNT_ID;
	}

	
}
