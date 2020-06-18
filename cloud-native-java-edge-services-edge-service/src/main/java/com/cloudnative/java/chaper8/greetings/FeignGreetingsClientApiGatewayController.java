package com.cloudnative.java.chaper8.greetings;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FeignGreetingsClientApiGatewayController {

	private final GreetingsClient greetingsClient;
	
	public FeignGreetingsClientApiGatewayController(GreetingsClient greetingsClient) {
		this.greetingsClient = greetingsClient;
	}
	
	@GetMapping("/feign/{name}")
	public GreetDto feign(@PathVariable String name) {
		return greetingsClient.greet(name);
	}
}
