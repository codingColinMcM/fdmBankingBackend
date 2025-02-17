package com.fdmgroup.bankUserStories.service;

import com.fdmgroup.bankUserStories.model.*;

import java.util.*;

public interface AccountService {
	
	public List<Account> getAccounts();
	public void removeAccount(Account account);
	public Account createAccount(Account account);

}