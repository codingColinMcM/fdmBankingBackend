package com.fdmgroup.bankUserStories.service;

public class FeeCalculatorServiceImplementation implements FeeCalculatorService{

	
	@Override
	public double calculateFee(double balance) {
		// TODO Auto-generated method stub
		double fee = 0.0;
		
		if(balance <= 100.0) {
			fee = 20.0;
		}
		else if(balance <= 500.0) {
			fee = 15.0;
		}
		else if(balance <= 1000.0) {
			fee = 10.0;
		}
		else if(balance <= 2000.0) {
			fee = 5.0;
		}
		
		return balance - fee;
	}
	

}
