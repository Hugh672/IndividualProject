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
}
