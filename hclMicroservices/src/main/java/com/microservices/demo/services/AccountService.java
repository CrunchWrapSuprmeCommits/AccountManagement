package com.microservices.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.microservices.demo.beans.Account;
import com.microservices.demo.controllers.AddResponse;
import com.microservices.demo.repositories.AccountRepository;

@Component
@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountrep;
	
	public List<Account> getAllAccounts() {
		return accountrep.findAll();
	}
	
	public Account getAccountbyID(int accountId) {
		return accountrep.findById(accountId).get();
	}
	
	public Account getAccountbyName(String accountName){
		List<Account> accounts = accountrep.findAll();
		Account account = null;
		for(Account acc:accounts) {
			if(acc.getAccountName().equalsIgnoreCase(accountName))
				account=acc;
		}
		return account;
	}
	
	public Account addAccount(Account account) {
		account.setAccountId(getMaxId());
		accountrep.save(account);
		return account;
	}
	
	
	public Account updateAccount(Account account) {
		accountrep.save(account);
		return account;
	}
	
	public AddResponse deleteAccount(int accountId) {
		accountrep.deleteById(accountId);
		AddResponse res = new AddResponse();
		res.setId(accountId);
		res.setMsg("Account deleted!");
		return res;
	}
	
	public int getMaxId() {
		return accountrep.findAll().size() + 1;
	}

}
