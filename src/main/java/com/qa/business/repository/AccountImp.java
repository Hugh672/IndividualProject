package com.qa.business.repository;



public interface AccountImp {

	String createAccount(String accountAsJSON);
	String updateAccount(long id, String accountAsJSON);
	String deleteAccount(Long id);
	String getAnAccount(Long id);
}
