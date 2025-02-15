package com.example.simpleWebApp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleWebApp.model.Account;
import com.example.simpleWebApp.service.AccountService;

@RestController
public class LoginController {

	@Autowired
	AccountService accountService;
	
    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        // Validate the input map
        String email = body.get("email");
        String password = body.get("password");
        
        if (email==null || password == null) {
        	return ResponseEntity.badRequest().body("Email and password are required");
        }
        try {
        	Account account = accountService.getAccountByEmail(email, password);
        	Map<String, String> response = new HashMap<>();
        	response.put("email", account.getAccountEmail());
        	response.put("name", account.getAccountName());
        	return ResponseEntity.ok(response);
        } catch (Exception e) {
        return ResponseEntity.status(404).body(e.getMessage());
        }
		
    }
}
