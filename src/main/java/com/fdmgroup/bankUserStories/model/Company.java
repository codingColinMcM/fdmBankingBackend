package com.fdmgroup.bankUserStories.model;

public class Company extends Customer {

	public Company(String name, String address) {
		super(name, address);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void chargeAllAccounts(double amount) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.getAccounts().size(); i++) {
			Account accountToCharge = this.getAccounts().get(i);
			if (accountToCharge.getClass().equals(SavingsAccount.class)) {
				accountToCharge.withdraw(2 * amount);
			}
			else {
				accountToCharge.withdraw(amount);
			}
		}
	}

}
