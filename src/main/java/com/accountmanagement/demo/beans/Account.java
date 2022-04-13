package com.accountmanagement.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	@Id
	@Column(name="AccountID")
	int id;
	
	@Column(name="AccountName")
	String accountName;
	
	public Account() {
		
	}
	
	public Account(int id, String accountName) {
		this.id = id;
		this.accountName = accountName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
}
