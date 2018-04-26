package com.qa.business.service;

import javax.inject.Inject;

import com.qa.business.repository.AccountImp;

public class ProjectService implements IProjectService {
	
	@Inject
	private AccountImp repo;

	@Override
	public String createAccount(String accountAsJSON) {
		return repo.createAccount(accountAsJSON);
	}

	@Override
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}

	@Override
	public String updateAccount(long id, String accountAsJSON) {
		return repo.updateAccount(id, accountAsJSON);
	}

	@Override
	public String getAnAccount(Long id) {
		return repo.getAnAccount(id);
	}

	
}
