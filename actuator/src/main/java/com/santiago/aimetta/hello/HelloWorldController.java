package com.santiago.aimetta.hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	private static final String helloTemplate = "Hello %s!";
	private static AtomicLong counter = new AtomicLong();
	
	@GetMapping(path = "/hello-world")
	@ResponseBody
	public 	Greeting sayHello(@RequestParam(name="name",required = false,defaultValue = "Stranger") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(helloTemplate, name));
	}
}
