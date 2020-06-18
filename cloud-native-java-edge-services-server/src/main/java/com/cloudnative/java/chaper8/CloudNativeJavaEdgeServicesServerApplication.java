package com.cloudnative.java.chaper8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CloudNativeJavaEdgeServicesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudNativeJavaEdgeServicesServerApplication.class, args);
	}

}
