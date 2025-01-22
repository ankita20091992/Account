package com.example.simpleWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleWebApp.model.Account;
import com.example.simpleWebApp.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired //it will create the objects
	AccountService service;
	
	@GetMapping("/accounts")
	public List<Account> getAccount() {
		//return the list of products
		return service.getAccount();
	}
	@GetMapping("/accounts/{accountId}")
	public Account getAccountByID(@PathVariable int accountId) {
		return service.getAccountById(accountId);
	}//@PathVariable used to match the prodId 

	@PostMapping("/accounts")
	public void addAccount(@RequestBody Account account) {
		//to receive from client to server-@Requestbody-
		//it will match the data and put into account
		System.out.println(account);
		service.addAccount(account);
	}
	
	@PutMapping("/accounts")
	public void updateAccount(@RequestBody Account account) {
		service.updateAccount(account);
	}
	
	@DeleteMapping("/accounts/{accountId}")
	public void deleteAccount(@PathVariable int accountId) {
		service.deleteAccount(accountId);
	}
	
}
