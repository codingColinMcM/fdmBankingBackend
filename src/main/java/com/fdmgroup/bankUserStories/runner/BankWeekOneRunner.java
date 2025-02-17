package com.fdmgroup.bankUserStories.runner;

import com.fdmgroup.bankUserStories.controllers.AccountController;
import com.fdmgroup.bankUserStories.model.*;
import java.util.*;

public class BankWeekOneRunner {
	
	public static void main(String args[]) {
		
		// AccountController tests
		List<Customer> customers = new ArrayList<>();
		List<Account> accounts = new ArrayList<>();
		
		Customer colin = new Person("Colin", "123 Main st");
		Customer alex = new Person("Akex", "987 Second st");
		Account truist = new CheckingAccount();
		Account bankOfAmerica = new CheckingAccount();

		customers.add(colin);
		customers.add(alex);
		accounts.add(truist);
		accounts.add(bankOfAmerica);
		
		
		colin.addAccount(truist);
		alex.addAccount(bankOfAmerica);
		
		AccountController aC = new AccountController(customers, accounts);
		
		Customer fDM = aC.createCustomer("FDM Group", "456 Broad Ave", "Company");
		Account accountToDoubleCharge = aC.createAccount(fDM, "SavingsAccount");
		Account accountToSingleCharge = aC.createAccount(fDM, "CheckingAccount");
		
		// testing AccountController removeCustomer part 1
		Customer customerToRemove = aC.createCustomer("No body", "Off the grid", "Person");
		aC.createAccount(customerToRemove, "CheckingAccount");
		Account accountToRemove = aC.createAccount(colin, "CheckingAccocunt");
		
		for (int i = 0; i < aC.getAccounts().size(); i++) {
			System.out.println(aC.getAccounts().get(i).getACCOUNT_ID());
		}
		
		for (int i = 0; i < aC.getCustomers().size(); i++) {
			System.out.println(aC.getCustomers().get(i).getCUSTOMER_ID());
//			System.out.println(aC.getCustomers().get(i).getClass());
		}
		
		// testing AccountController remove methods part 2
		aC.removeAccount(accountToRemove);
		aC.removeCustomer(customerToRemove);
		
		System.out.println();
		System.out.println();

		
		for (int i = 0; i < aC.getAccounts().size(); i++) {
			System.out.println(aC.getAccounts().get(i).getACCOUNT_ID());
		}
		
		for (int i = 0; i < aC.getCustomers().size(); i++) {
			System.out.println(aC.getCustomers().get(i).getCUSTOMER_ID());
		}
		
		// SavingsAccount test
		System.out.println();
		System.out.println();
		SavingsAccount aDTC = (SavingsAccount) accountToDoubleCharge;
		aDTC.setBalance(100);
		System.out.println(aDTC.getBalance());
		aDTC.setInterestRate(10);
		aDTC.addInterest();
		System.out.println(aDTC.getBalance());
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		aC.getAccounts();
		String typeSavings = truist.getClass().toString();
		for (int i = 0; i < aC.getAccounts().size(); i++) {

			String thisType = aC.getAccounts().get(i).getClass().toString();
			
			if(thisType.equals(typeSavings)) {
				System.out.println(aC.getAccounts().get(i).toString());
			}
			
		}
		
//		// CheckingAccount test
//		CheckingAccount checkNumVerification = new CheckingAccount();
//		System.out.println(checkNumVerification.getNextCheckNumber());
//		System.out.println(checkNumVerification.getNextCheckNumber());
//
//		// Company Test
//		Company chargeAllVerification = new Company("Microsoft", "Your PC");
//		SavingsAccount doubleChargeVerification = new SavingsAccount();
//		doubleChargeVerification.deposit(100);
//		chargeAllVerification.addAccount(doubleChargeVerification);
//		CheckingAccount singleChargeVerification = new CheckingAccount();
//		singleChargeVerification.correctBalance(100);
//		chargeAllVerification.addAccount(singleChargeVerification);
//		chargeAllVerification.chargeAllAccounts(25);
//		
//		for (Account account : chargeAllVerification.getAccounts()) {
//			System.out.println(account.getBalance());
//		}
//		
//		// Person Test
//		Person chargeEquallyVerification = new Person("Mom", "Florida");
//		SavingsAccount savingsVerification = new SavingsAccount();
//		savingsVerification.deposit(100);
//		chargeEquallyVerification.addAccount(savingsVerification);
//		CheckingAccount checkingVerification = new CheckingAccount();
//		checkingVerification.correctBalance(100);
//		chargeEquallyVerification.addAccount(checkingVerification);
//		chargeEquallyVerification.chargeAllAccounts(10);
//		
//		for (Account account : chargeEquallyVerification.getAccounts()) {
//			System.out.println(account.getBalance());
//		}
		
	}

}
