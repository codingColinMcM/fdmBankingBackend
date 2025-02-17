package com.fdmgroup.bankUserStories.service;

import com.fdmgroup.bankUserStories.model.*;

import com.fdmgroup.bankUserStories.dao.*;

import java.util.*;

public class AccountServiceImplementation implements AccountService {
	
	private AccountReaderDAO accReaderDao;
	private AccountWriterDAO accWriterDao;
	
	

	public AccountServiceImplementation(AccountReaderDAO accReaderDao, AccountWriterDAO accWriterDao) {
		this.accReaderDao = accReaderDao;
		this.accWriterDao = accWriterDao;
	}

	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return accReaderDao.readAccounts();
	}

	@Override
	public void removeAccount(Account account) {
		// TODO Auto-generated method stub
		accWriterDao.deleteAccount(account);
	}

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accWriterDao.createAccount(account);
	}

}
