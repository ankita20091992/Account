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
//	List<Account> accounts = new ArrayList<>(Arrays.asList(
//			new Account(101, "Ram", "ram07@x.com", "0702" ),
//			new Account(102, "Shyam","shyam02@x.com", "0803"),
//			new Account(103, "Sita", "sita77@z.com", "0589")
//			));
//	
	public List<Account> getAccount() {
		return repo.findAll();
	}

	public Account getAccountById(int accountId) {
		return repo.findById(accountId).orElse(new Account());
	}

	public void addAccount(Account account) {
		repo.save(account);
	}

	public void updateAccount(Account account) {
		repo.save(account);
		
	}

	public void deleteAccount(int accountId) {
		repo.deleteById(accountId);
		
	}
}
