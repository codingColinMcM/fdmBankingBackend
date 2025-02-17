package com.fdmgroup.bankUserStories.model;

public class CheckingAccount extends Account{ 
	
	private int nextCheckNumber = 0;

	public CheckingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNextCheckNumber() {
		nextCheckNumber++;
		return nextCheckNumber;
	}

	public void setNextCheckNumber(int nextCheckNumber) {
		this.nextCheckNumber = nextCheckNumber;
	}

	@Override
	public String toString() {
		return "CheckingAccount [nextCheckNumber=" + nextCheckNumber + ", balance=" + balance + "]";
	}
	
	

}
