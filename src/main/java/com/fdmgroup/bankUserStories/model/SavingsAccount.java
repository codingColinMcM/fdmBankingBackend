package com.fdmgroup.bankUserStories.model;

public class SavingsAccount extends Account {
	
	private double interestRate;
	
	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addInterest() {
		this.balance += this.balance * this.interestRate / 100;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + ", balance=" + balance + "]";
	}
	
	

}
