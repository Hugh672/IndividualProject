package com.qa.business.service;

public interface IProjectService {
	
	String createAccount(String accountAsJSON);
	String deleteAccount(Long id);
	String updateAccount(long id, String accountAsJSON);
	String getAnAccount(Long id);
}
