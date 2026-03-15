package com.fintech.aggregator.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlphaClient {

	private final RestTemplate restTemplate = new RestTemplate();

	public String getAccounts(String userId) {
		return restTemplate.getForObject(
				"http://localhost:8081/accounts/" + userId,
				String.class);
	}
}
