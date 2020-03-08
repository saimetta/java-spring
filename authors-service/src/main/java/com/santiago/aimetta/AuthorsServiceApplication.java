package com.santiago.aimetta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthorsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorsServiceApplication.class, args);
	}

}
