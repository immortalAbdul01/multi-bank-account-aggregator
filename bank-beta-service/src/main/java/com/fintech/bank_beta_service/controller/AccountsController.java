package com.fintech.bank_beta_service.controller;

import com.fintech.bank_beta_service.model.Account;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountsController {

	@GetMapping("/accounts/{userId}")
	public List<Account> getAccounts(@PathVariable String userId) {

		return List.of(
				new Account("A101", "Alpha Bank", 15000),
				new Account("A102", "Alpha Bank", 8200));
	}
}
