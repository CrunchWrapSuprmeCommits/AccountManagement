package com.accountmanagement.demo.services;

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
		List<Account> accounts = accountRepo.findAll();
		Account account = null;
		
		for(Account acc:accounts) {
			if(acc.getAccountName().equalsIgnoreCase(accountName))
				account = acc;
		}
		return account;
	}
	
	//add account using max id method
	public Account addAccount(Account account) {
		account.setId(getMaxId());
		accountRepo.save(account);
		return account;
	}
	
	//utility method for max id
	public int getMaxId() {
		return accountRepo.findAll().size() + 1;
	}
	
	//update existing account
	public Account updateAccount(Account account) {
		accountRepo.save(account);
		return account;
	}
	
	//deleting account
	public AddResponse deleteAccount(int id) {
		accountRepo.deleteById(id);
		AddResponse res = new AddResponse();
		res.setId(id);
		res.setMsg("Account Deleted!");
		return res;
	}
}
