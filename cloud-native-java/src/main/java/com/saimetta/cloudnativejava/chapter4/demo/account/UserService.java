package com.saimetta.cloudnativejava.chapter4.demo.account;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	private final String serviceHost;
	private final RestTemplate restTemplate;
	
	public UserService(
			@Value("${user-service.host:user-service}")
			String serviceHost,
			RestTemplate restTemplate) {
		this.serviceHost = serviceHost;
		this.restTemplate = restTemplate;
	}
	
	public User getAuthenticatedUser() {
		URI url = URI.create(String.format("http://%s/uaa/v1/me", serviceHost));
		return restTemplate.getForObject(url, User.class);
	}
}
