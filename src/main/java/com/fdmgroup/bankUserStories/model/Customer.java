package com.fdmgroup.bankUserStories.model;

import java.util.*;

public abstract class Customer {
	
	private final long CUSTOMER_ID;
	private static long nextCustomerId;
	private String name;
	private String address;
	private List<Account> accounts = new ArrayList<>();
	
	public Customer(String name, String address) {
		CUSTOMER_ID = 200000 + nextCustomerId;
		nextCustomerId += 7;
		this.name = name;
		this.address = address;
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	
	public void removeAccount(Account account) {
		for (int i = 0; i < this.accounts.size(); i++) {
			Account accountIteration = this.accounts.get(i);
			if (accountIteration.equals(account)) {
				this.accounts.remove(i);
			}
		}
	}
	
	public abstract void chargeAllAccounts(double amount);
	
	public static long getNextCustomerId() {
		return Customer.nextCustomerId;
	}
	public static void setNextCustomerId(long nextCustomerId) {
		Customer.nextCustomerId = nextCustomerId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Account> getAccounts() {
		return this.accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public long getCUSTOMER_ID() {
		return this.CUSTOMER_ID;
	}

}
