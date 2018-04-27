package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id @GeneratedValue
	private Long id;
	private String firstName;
	private String surname;
	private String accNo;
	
	public Account() {}
	
	public Account(String firstName, String lastName, String accountNumber) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.accNo = accNo;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
	
}
