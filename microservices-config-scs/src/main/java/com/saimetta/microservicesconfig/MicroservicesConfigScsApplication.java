package com.saimetta.microservicesconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MicroservicesConfigScsApplication {

	public static void main(String[] args) {
		/**
		 * Default port is 8888
		 * configuration will be found in host:8888/<application-name or config-file-name>/<profile>
		 * example localhost:8888/application/default
		 *         localhost:8888/microservice-one/test
		 * 
		 */
		SpringApplication.run(MicroservicesConfigScsApplication.class, args);
	}

}
