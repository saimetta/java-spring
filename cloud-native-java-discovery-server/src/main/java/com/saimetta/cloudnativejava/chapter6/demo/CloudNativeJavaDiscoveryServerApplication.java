package com.saimetta.cloudnativejava.chapter6.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CloudNativeJavaDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudNativeJavaDiscoveryServerApplication.class, args);
	}

}
