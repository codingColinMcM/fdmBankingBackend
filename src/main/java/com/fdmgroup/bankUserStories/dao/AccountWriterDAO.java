package com.fdmgroup.bankUserStories.dao;

import com.fdmgroup.bankUserStories.model.*;

public interface AccountWriterDAO {
	
	public Account createAccount(Account account);
	public void deleteAccount(Account account);

}
