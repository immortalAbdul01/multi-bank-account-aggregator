package com.fintech.aggregator.service;

import com.fintech.aggregator.client.AlphaClient;
import com.fintech.aggregator.client.BetaClient;
import com.fintech.aggregator.model.AggregatedAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAggregatorService {

	@Autowired
	private AlphaClient alphaClient;

	@Autowired
	private BetaClient betaClient;

	public AggregatedAccountResponse getAccounts(String userId) {

		Object alphaAccounts = alphaClient.getAccounts(userId);
		Object betaAccounts = betaClient.getAccounts(userId);

		AggregatedAccountResponse response = new AggregatedAccountResponse();
		response.setAlphaBank(alphaAccounts);
		response.setBetaBank(betaAccounts);

		return response;
	}
}
