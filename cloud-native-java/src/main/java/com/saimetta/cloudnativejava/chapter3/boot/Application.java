package com.saimetta.cloudnativejava.chapter3.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class Application {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	public Application(ConfigurationProjectProperties cp) {
		log.info("ConfigurationProjectProperties.projectName: " + cp.getProjectName());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
