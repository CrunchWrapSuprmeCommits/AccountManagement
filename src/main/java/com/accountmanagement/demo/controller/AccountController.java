package com.accountmanagement.demo.controller;

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

import com.accountmanagement.demo.beans.Account;
import com.accountmanagement.demo.services.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/getaccounts")
	public List<Account> getAccounts() {
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/getaccounts/{id}")
	public ResponseEntity<Account> getAccountByID(@PathVariable(value = "id") int id) {
		
		try {
			Account account = accountService.getAccountbyID(id);
			return new ResponseEntity<Account>(account,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getaccounts/accountname")
	public ResponseEntity<Account> getAccountByName(@RequestParam(value = "name") String accountName) {
		
		try {
			Account account = accountService.getAccountbyName(accountName);
			return new ResponseEntity<Account>(account,HttpStatus.OK);
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
	public ResponseEntity<Account> updateAccount(@PathVariable(value="id") int id, @RequestBody Account account) {
		try {
			Account existAccount = accountService.getAccountbyID(id);
			existAccount.setAccountName(account.getAccountName());
			
			Account updatedAccount = accountService.updateAccount(existAccount);
			return new ResponseEntity<Account>(updatedAccount, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	@DeleteMapping("/deleteaccount/{id}")
	public AddResponse deleteAccount(@PathVariable(value="id") int id) {
		return accountService.deleteAccount(id);
	}
	
}
