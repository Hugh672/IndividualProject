package com.qa.business.repository;

import com.qa.persistence.domain.Account;

public interface AccountImp {

	String createAccount(String accountAsJSON);
	String updateAccount(long id, String accountAsJSON);
	String deleteAccount(Long id);
	String getAnAccount(Long id);
}
