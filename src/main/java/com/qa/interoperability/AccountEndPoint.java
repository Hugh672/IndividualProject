package com.qa.interoperability;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IProjectService;

	
@Path("/account")
public class AccountEndPoint {
		
	@Inject
	private IProjectService service;
		
	@POST
	@Path("/create")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public String createAccount(String accountAsJSON) {
	return service.createAccount(accountAsJSON);
		}

	@PUT
	@Path("/update/{id}")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public String updateAccount(@PathParam("id")long id, String accountAsJSON) {
	return service.updateAccount(id, accountAsJSON);
		}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public String deleteAccount(@PathParam("id")Long id) {
		return service.deleteAccount(id);
	}
			
	@GET
	@Path("/get/{id}")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public String getAnAccount(@PathParam("id")Long id) {
		return service.getAnAccount(id);
	}
	
	}