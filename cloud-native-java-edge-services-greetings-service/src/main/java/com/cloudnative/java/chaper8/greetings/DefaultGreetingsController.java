package com.cloudnative.java.chaper8.greetings;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile({"default", "insecure"})
public class DefaultGreetingsController {

	@GetMapping("/greet/{name}")
	public GreetDto hi(@PathVariable String name) {
		return new GreetDto(name);
	}  
}
