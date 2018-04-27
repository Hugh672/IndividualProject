package com.qa.business.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;


@Default
public class AccountDB implements AccountImp {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	JSONUtil ju;
	
	@Override
	@Transactional(REQUIRED)
    public String createAccount(String accountAsJSON) {
		manager.persist(ju.getObjectForJSON(accountAsJSON, Account.class));
    	return "{\"Message\": Account Created\"}";
    }
    
    @Override
	@Transactional(REQUIRED)
    public String deleteAccount(Long id) {
    	Account account = manager.find(Account.class,id);
    	if (account!= null) {
    		manager.remove(account);
    	
    	return "{\"Message\":\"Account has been deleted\"}";
    	
    } else {
    }
    	return "{\"message\": \"Account does not exist!\"}";
    }
   
    @Override
	@Transactional(REQUIRED)
    public String updateAccount(long id, String accountAsJSON) {
    	Account original=manager.find(Account.class,id);
    	Account updated=ju.getObjectForJSON(accountAsJSON,Account.class);
    	if (original!=null) {
    		manager.merge(updated);
    		return  "{\"Message\":\"Account has been updated\"}";
    	}
    	
    	return  "{\"Message\":\"Account has not been updated\"}";
    }
    
    @Override
    public String getAnAccount(Long id) {
    	Account anAccount = manager.find(Account.class,id);;
    	
    	if(anAccount != null) {
    		return ju.getJSONForObject(anAccount);
    	}
    	else
    	{
    		return "(\"message\":\"Account not found\")";
    	}
    	
    }
	public void setEntityManager(EntityManager manager) {
		this.manager = manager;
	
	}

	public void setJSONUtil(JSONUtil ju) {
		this.ju = ju;
		
	}
    
    
}
