package com.qa.business.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Default
@Transactional
public class AccountDB implements AccountImp {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	JSONUtil ju;
	
	@Override
	@Transactional(REQUIRED)
    public String createAccount(Account account) {
		manager.persist(account);
    	return "Account has been created";
    }
    
    @Override
	@Transactional(REQUIRED)
    public String deleteAccount(Account account) {
    	manager.remove(account);
    	return "Account has been deleted";
    }
   
    @Override
	@Transactional(REQUIRED)
    public String updateAccount(long id, String accountAsJSON) {
    	Account original=manager.find(Account.class,id);
    	Account updated=ju.getObjectForJSON(accountAsJSON,Account.class);
    	if (original!=null) {
    		manager.merge(updated);
    		return "Account has been updated";
    	}
    	
    	return "Account has not been updated";
    }

}
