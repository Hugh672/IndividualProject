package com.qa.business.repository;

import com.qa.persistence.domain.Account;

public interface AccountImp {

	String createAccount(Account account);
	String updateAccount(long id, String accountAsJSON);
	String deleteAccount(Account account);
	
}
