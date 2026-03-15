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

	@GetMapping("/alpha/accounts/{userId}")
	public String alphaAccounts(@PathVariable String userId) {
		return alphaClient.getAccounts(userId);
	}

	@GetMapping("/beta/accounts/{userId}")
	public String betaAccounts(@PathVariable String userId) {
		return betaClient.getAccounts(userId);
	}
}
