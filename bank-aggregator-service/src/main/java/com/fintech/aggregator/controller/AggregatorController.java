package com.fintech.aggregator.controller;

import com.fintech.aggregator.client.AlphaClient;
import com.fintech.aggregator.client.BetaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banks")
public class AggregatorController {

	@Autowired
	private AlphaClient alphaClient;

	@Autowired
	private BetaClient betaClient;

	@GetMapping("/alpha/accounts")
	public String alphaAccounts() {
		return alphaClient.getAccounts();
	}

	@GetMapping("/beta/accounts")
	public String betaAccounts() {
		return betaClient.getAccounts();
	}
}
