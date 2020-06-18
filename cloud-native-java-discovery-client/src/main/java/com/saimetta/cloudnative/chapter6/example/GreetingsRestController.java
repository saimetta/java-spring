package com.saimetta.cloudnative.chapter6.example;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsRestController {

	@GetMapping(value = "/hi/{name}")
	public Map<String,String> hi(@PathVariable String name, 
								 @RequestHeader(value = "X-CNJ-Name", required = false) Optional<String> cn) {
		String resolvedName = cn.orElse(name);
		return Collections.singletonMap("greeting", String.format("Hello %s", resolvedName));
		
	}
}
