package com.fdmgroup.bankUserStories.model;

public class SmallSafetyDepositBox extends SafetyDepositBox {

	private double capacity;
	
	public SmallSafetyDepositBox() {
		super();
	}
	
	public SmallSafetyDepositBox(double capacity) {
		super();
		this.capacity = capacity;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

}
