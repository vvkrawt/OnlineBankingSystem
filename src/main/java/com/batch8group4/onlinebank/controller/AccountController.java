package com.batch8group4.onlinebank.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.batch8group4.onlinebank.model.Account;
import com.batch8group4.onlinebank.model.Customer;
import com.batch8group4.onlinebank.service.AccountService;
import com.batch8group4.onlinebank.service.CustomerService;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@GetMapping("/account")
	public List<Account> getAllCustomersResponse ()
	{
		return accountService.getAllAccounts();
	}
	
}
