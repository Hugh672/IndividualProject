package com.qa.business;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mockito;

import com.qa.business.repository.AccountDB;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AccountDBRepoTest {

	@InjectMocks
	private AccountDB repo;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private TypedQuery<Account> query;
	
	@Mock
	Account account = new Account("Hugh", "Grierson", "1234");
	
	private JSONUtil ju;
	
	private static final String ACCOUNT_AS_JSON = "{\"firstName\":\"Hugh\",\"surname\":\"Grierson\",\"accNo\":\"1234\"}";
	
	@Before
	public void initialise() {
		repo.setEntityManager(manager);
		ju = new JSONUtil();
		repo.setJSONUtil(ju);
	}
	
	@Test
	public void testCreateAccount() {
		String expectedValue = "{\"Message\": Account Created\"}";
		String actualValue = repo.createAccount(ACCOUNT_AS_JSON);
		Assert.assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testUpdateAccount() {
		String expectedValue = "{\"Message\":\"Account has not been updated\"}";
		String actualValue = repo.updateAccount(123L, ACCOUNT_AS_JSON);
		Assert.assertEquals(expectedValue, actualValue);
		
		Mockito.when(manager.find(Mockito.eq(Account.class), Mockito.anyLong())).thenReturn(account);
		
		expectedValue = "{\"Message\":\"Account has been updated\"}";
		actualValue = repo.updateAccount(123L, ACCOUNT_AS_JSON);
		Assert.assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testDeleteAccount() {
		String expectedValue = "{\"message\": \"Account does not exist!\"}";
		String actualValue = repo.deleteAccount(123L);
		Assert.assertEquals(expectedValue, actualValue);
		
		Mockito.when(manager.find(Mockito.eq(Account.class), Mockito.anyLong())).thenReturn(account);
		
		expectedValue = "{\"Message\":\"Account has been deleted\"}";
		actualValue = repo.deleteAccount(123L);
		Assert.assertEquals(expectedValue, actualValue);
	}
}
