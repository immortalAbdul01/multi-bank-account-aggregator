package com.fintech.bank_beta_service.controller;

import com.fintech.bank_beta_service.model.Account;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountsController {

	@GetMapping("/accounts/{userId}")
	public List<Account> getAccounts(@PathVariable String userId) {

		return List.of(
				new Account("B101", "Beta Bank", 15000),
				new Account("B102", "Beta Bank", 8200));
	}
}
