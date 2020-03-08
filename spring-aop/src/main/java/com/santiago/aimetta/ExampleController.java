package com.santiago.aimetta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

	
	@Autowired
	private Process p;
	@GetMapping(path = "/test")
	@ResponseBody
	public String test() {
		
		
		
		p.processThatTakes1Second();
		System.out.println("processThatTakes1Second finished!");
		
		p.processThatTakes2Seconds();
		System.out.println("processThatTakes2Seconds finished!");
		
		p.processThatTakesHalfSecond();
		System.out.println("processThatTakesHalfSecond finished!");
		
		return "Hello";


	}

}
