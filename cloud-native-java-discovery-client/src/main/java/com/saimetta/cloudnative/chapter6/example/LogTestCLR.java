package com.saimetta.cloudnative.chapter6.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LogTestCLR implements CommandLineRunner{

	private Log log = LogFactory.getLog(getClass());
	@Override
	public void run(String... args) throws Exception {
		log.info(">>>>>>>>LogTestCLR CALL!!!!>>>>>>>>>>");
		
	}

}
