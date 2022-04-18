package com.microservices.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.demo.beans.Account;
import com.microservices.demo.services.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/getaccounts")
	public List<Account> getAccount() {
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/getaccount/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable(value="id") int accountId) {
		
		try {
			
			Account account = accountService.getAccountbyID(accountId);
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getaccount/accountname")
	public ResponseEntity<Account> getAccountByName(@RequestParam(value="name") String accountName) {
		try {
			
			Account account = accountService.getAccountbyName(accountName);
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addaccount")
	public Account addAccount(@RequestBody Account account) {
		return accountService.addAccount(account);
	}
	
	@PutMapping("/updateaccount/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable(value="id") int accountId, @RequestBody Account account) {
		try {
			Account existAccount = accountService.getAccountbyID(accountId);
			
			existAccount.setAccountName(account.getAccountName());
			existAccount.setAccountEmail(account.getAccountEmail());
			
			Account updated_account = accountService.updateAccount(existAccount);
			return new ResponseEntity<Account>(updated_account, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/deleteaccount/{id}")
	public AddResponse deleteAccount(@PathVariable(value="id") int accountId) {
		return accountService.deleteAccount(accountId);
	}

}
