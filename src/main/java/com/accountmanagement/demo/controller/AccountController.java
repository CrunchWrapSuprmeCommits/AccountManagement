package com.accountmanagement.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List getAccounts() {
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/getaccounts/{id}")
	public Account getAccountByID(@PathVariable(value = "id") int id) {
		return accountService.getAccountbyID(id);
	}
	
	@GetMapping("/getaccounts/accountname")
	public Account getAccountByName(@RequestParam(value = "name") String accountName) {
		return accountService.getAccountbyName(accountName);
	}
	
	@PostMapping("/addaccount")
	public Account addAccount(@RequestBody Account account) {
		return accountService.addAccount(account);
	}
	
	@PutMapping("/updateaccount")
	public Account updateAccount(@RequestBody Account account) {
		return accountService.updateAccount(account);
	}
	
	@DeleteMapping("/deleteaccount/{id}")
	public AddResponse deleteAccount(@PathVariable(value="id") int id) {
		return accountService.deleteAccount(id);
	}
	
}
