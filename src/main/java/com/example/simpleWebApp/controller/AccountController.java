package com.example.simpleWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleWebApp.model.Account;
import com.example.simpleWebApp.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired //it will create the objects
	AccountService service;
	
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAccount() {
		//return the list of products
		return ResponseEntity.ok(service.getAccount());
	}
	
	@GetMapping("/accounts/{accountId}")
	public ResponseEntity<Account> getAccountByID(@PathVariable int accountId) {
		return ResponseEntity.ok(service.getAccountById(accountId));
	}//@PathVariable used to match the prodId 

	@PostMapping("/accounts")
	public ResponseEntity<String> addAccount(@RequestBody Account account) {
		//to receive from client to server-@Requestbody-
		//it will match the data and put into account
		try {
			service.addAccount(account);
			return ResponseEntity.ok("Account created successfully");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/accounts")
	public ResponseEntity<String> updateAccount(@RequestBody Account account) {
		service.updateAccount(account);
		return ResponseEntity.ok("Account updated successfully");
	}
	
	@DeleteMapping("/accounts/{accountId}")
	public ResponseEntity<String> deleteAccount(@PathVariable int accountId) {
		service.deleteAccount(accountId);
		return ResponseEntity.ok("Account deleted successfully");
	}
	
}
