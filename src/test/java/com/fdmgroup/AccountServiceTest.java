package com.fdmgroup;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import com.fdmgroup.bankUserStories.model.*;
import com.fdmgroup.bankUserStories.service.*;
import com.fdmgroup.bankUserStories.dao.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
	
	AccountServiceImplementation aSI;
	
	@Mock
	Account mockAccount;

	@Mock
	AccountReaderDAO mockAcctReadDAO;
	
	@Mock
	AccountWriterDAO mockAcctWriteDAO;
	
	@BeforeEach
	void setUp() {
		mockAccount = mock(Account.class);
		mockAcctReadDAO = mock(AccountReaderDAO.class);
		mockAcctWriteDAO = mock(AccountWriterDAO.class);
		aSI = new AccountServiceImplementation(mockAcctReadDAO, mockAcctWriteDAO);
	}
	
	@Test
	void testGetAccounts_ReturnListOfAccountsThatAreProvidedByTheAccountReaderDAOReadAccountsMethod_WhenGetAccountsIsCalled() {
		List<Account> expectedAccounts = new ArrayList<>();	
		
		expectedAccounts.add(mockAccount);
		when(mockAcctReadDAO.readAccounts()).thenReturn(expectedAccounts);
		
		assertEquals(expectedAccounts, aSI.getAccounts());
	}
	
	@Test
	void testRemoveAccount_VerifyThatDeleteAccountUsesDeleteAccountFromAccountWriterDAO_WhenRemoveAccountIsCalled() {
		
		aSI.removeAccount(mockAccount);
		
		verify(mockAcctWriteDAO, times(1)).deleteAccount(any(Account.class));
		
	}
	
	@Test
	void testCreateAccount_VerifyThatCreateAccountUsesCreateAccountFromAccountWriterDAO_WhenCreateAccountIsCalled() {
		
		aSI.createAccount(mockAccount);
		
		verify(mockAcctWriteDAO, times(1)).createAccount(any(Account.class));
		
	}

}
