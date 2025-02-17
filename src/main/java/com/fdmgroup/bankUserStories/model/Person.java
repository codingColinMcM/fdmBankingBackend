package com.fdmgroup.bankUserStories.model;

public class Person extends Customer {

	public Person(String name, String address) {
		super(name, address);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void chargeAllAccounts(double amount) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.getAccounts().size(); i++) {
			Account accountToCharge = this.getAccounts().get(i);
			accountToCharge.withdraw(amount);
		}
	}
	
}
