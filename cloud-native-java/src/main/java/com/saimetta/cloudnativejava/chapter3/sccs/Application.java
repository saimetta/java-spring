package com.saimetta.cloudnativejava.chapter3.sccs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//when run, check http://localhost:8888/configuration-client/master and
		//see the configuration being loaded from the repo specified in 
		//application.properties: spring.cloud.config.server.git.uri
		
		//curl POST -d {} http://127.0.0.1:9999/actuator/refresh
		//to trigger the refresh event so the beans annotated will reload its config
	}

}
