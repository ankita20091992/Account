package com.example.simpleWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simpleWebApp.model.Account;
import com.example.simpleWebApp.repository.AccountRepo;

@Service
public class AccountService {
	
	@Autowired
	AccountRepo repo;

	public List<Account> getAccount() {
		return repo.findAll();
	}

	public Account getAccountById(int accountId) {
		return repo.findById(accountId).orElse(null);
	}

	public Account getAccountByEmail(String accountEmail, String password) {
		Account account=repo.findByEmail(accountEmail);
		if(account!=null) {
			if(account.getPassword().equals(password)) {
				return account;
			}
			else {
				throw new RuntimeException("Password is incorrect");
			}
		}
		else {
			throw new RuntimeException("Email does not exist");
		}
	}
	
	
	
	public void addAccount(Account account) {
		Account existingAccount = repo.findByEmail(account.getAccountEmail());
		if (existingAccount!=null) {
			throw new RuntimeException("Email already exists");
		}
		else {
			repo.save(account);
		}
	}
	

	public void updateAccount(Account account) {
		repo.save(account);
		
	}

	public void deleteAccount(int accountId) {
		repo.deleteById(accountId);
		
	}
}
