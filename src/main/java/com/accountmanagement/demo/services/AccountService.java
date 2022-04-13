package com.accountmanagement.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.accountmanagement.demo.beans.Account;
import com.accountmanagement.demo.controller.AddResponse;
import com.accountmanagement.demo.repositories.AccountRepository;

@Component
@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepo;
	
	//list all account
	public List<Account> getAllAccounts() {
		return accountRepo.findAll();
	}
	
	//list account by id
	public Account getAccountbyID(int id) {
		return accountRepo.findById(id).get();
	}
	
	//list account by name
	public Account getAccountbyName(String accountName) {
		
	}
	
	//add account using max id method
	public Account addAccount(Account account) {
		
	}
	
	//utility method for max id
	public static int getMaxId() {
		
	}
	
	//update existing account
	public Account updateAccount(Account account) {
		
	}
	
	//deleting account
	public AddResponse deleteAccount(int id) {
		
	}
}
