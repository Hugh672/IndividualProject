package com.qa.business.service;

import javax.inject.Inject;

import com.qa.business.repository.AccountImp;

public class ProjectService implements IProjectService {
	
	@Inject
	private AccountImp repo;

	@Override
	public String getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
