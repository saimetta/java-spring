package com.cloudnative.java.chaper8.greetings;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("greetings-service")
public interface GreetingsClient {
	
	@GetMapping("/greet/{name}")
	public GreetDto greet(@PathVariable("name") String name);

}
