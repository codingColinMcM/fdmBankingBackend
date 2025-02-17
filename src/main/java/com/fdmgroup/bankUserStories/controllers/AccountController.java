package com.fdmgroup.bankUserStories.controllers;

import com.fdmgroup.bankUserStories.model.*;
import java.util.*;

public class AccountController {
	
	private List<Customer> customers;
	private List<Account> accounts;
	
	public AccountController(List<Customer> customers, List<Account> accounts) {
		this.customers = customers;
		this.accounts = accounts;
	}

	public Customer createCustomer(String name, String address, String type) {
		
		Customer customer;
		
		if (type.equals("Company")) {
			customer = new Company(name, address);
		}
		else {
			customer = new Person(name, address);
		}
		
		this.customers.add(customer);
		return customer;
	}
	
	public Account createAccount(Customer customer, String type) {
		
		Account account;
		
		if(type.equals("SavingsAccount")) {
			account = new SavingsAccount();
		}
		else {
			account = new CheckingAccount();
		}
		
		customer.addAccount(account);
		this.accounts.add(account);
		return account;
	}
	
	public void removeCustomer(Customer customer) {
		
		for (int j = 0; j < customer.getAccounts().size(); j++) {
			removeAccount(customer.getAccounts().get(j));
		}
		
		for (int i = 0; i < this.customers.size(); i++) {
			Customer examineCustomer = this.customers.get(i);
			
			if(examineCustomer.equals(customer)) {
				customers.remove(i);
			}
		}
	}
	
	public void removeAccount(Account account) {
		for (int i = 0; i < this.accounts.size(); i++) {
			Account accountToRemove = this.accounts.get(i);
			if(accountToRemove.equals(account)) {
				accounts.remove(i);
			}
		}
	}
	
	public List<Customer> getCustomers() {
		return this.customers;
	}
	
	public List<Account> getAccounts() {
		return this.accounts;
	}

}
