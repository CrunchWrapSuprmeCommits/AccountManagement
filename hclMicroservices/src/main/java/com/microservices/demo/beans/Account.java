package com.microservices.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@Column(name="id")
	int accountId;
	
	@Column(name="name")
	String accountName;
	
	@Column(name="email")
	String accountEmail;
	
	public Account() {
		
	}

	public Account(int accountId, String accountName, String accountEmail) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountEmail = accountEmail;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountEmail() {
		return accountEmail;
	}
	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	
}