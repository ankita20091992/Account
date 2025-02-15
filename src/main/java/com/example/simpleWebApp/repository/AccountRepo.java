package com.example.simpleWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simpleWebApp.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

	Account findByEmail(String Email);

}
