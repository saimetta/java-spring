package com.cloudnative.java.chaper8.greetings;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Profile({"default","insecure"})
@RestController
@RequestMapping("/api")
public class RestTemplateGreetingdClientApiGatewayController {
	
	private final RestTemplate restTemplate;
	
	public RestTemplateGreetingdClientApiGatewayController(@LoadBalanced RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/resttemplate/{name}")
	public GreetDto restTemplate(@PathVariable String name) {
		ResponseEntity<GreetDto> responseEntity = this.restTemplate.getForEntity("http://greetings-service/greet/{name}", GreetDto.class, name);
		return responseEntity.getBody();
	}
}
