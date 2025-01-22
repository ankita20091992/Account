package com.example.simpleWebApp.model;


import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Component
@Entity
public class Account {
	@Id
	private int accountId;
	private String accountName;
	private String accountEmail;
	private String Password;
	
	public Account() {
	
	}

	public Account(int accountId, String accountName, String accountEmail, String password) {
		
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountEmail = accountEmail;
		//Password = password;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Account "
				+ "[accountId=" + accountId + 
				", accountName=" + accountName + 
				", accountEmail=" + accountEmail + 
				", Password=" + Password + 
				"]";
	}

	

	
	
	
}
 