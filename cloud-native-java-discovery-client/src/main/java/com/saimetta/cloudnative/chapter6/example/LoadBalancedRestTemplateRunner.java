package com.saimetta.cloudnative.chapter6.example;

import java.util.Collections;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@Component
public class LoadBalancedRestTemplateRunner implements ApplicationRunner {

	private final RestTemplate restTemplate;
	private final Log log = LogFactory.getLog(getClass());

	
	public LoadBalancedRestTemplateRunner(	@LoadBalanced RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {

		Map<String,String> variables = Collections.singletonMap("name", "Tino Cloud Natives");
		ResponseEntity<JsonNode> response = restTemplate.getForEntity("http://greetings-service/hi/{name}", JsonNode.class, variables);
		JsonNode body = response.getBody();
		log.info(String.format("LoadBalancedRestTemplateRunner>>>>>>> Greeting: %s", body.get("greeting").asText()));
	}

}
