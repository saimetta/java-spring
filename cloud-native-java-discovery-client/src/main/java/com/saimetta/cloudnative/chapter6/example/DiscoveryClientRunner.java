package com.saimetta.cloudnative.chapter6.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class DiscoveryClientRunner implements ApplicationRunner {
	
	private final DiscoveryClient discoveryClient;
	private final Log log = LogFactory.getLog(getClass());
	@Value("${spring.application.name}")
	private String serviceId;
	
	public DiscoveryClientRunner(DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/**
		 * Since this is an ApplicationRunner, will be executed when SpringApp bootstraps
		 * This will log info about instaces discovered, if this is the first service instance
		 * there wont be other instances discovered by DiscoveryClient
		 * Notice that @ENableDiscoveryClient is not used in the app, we are using our current implementation
		 * to discover other services with that serviceId
		 */
		log.info(">>>>>>>>>LocalServiceInstance");
		log.info(String.format(">>>>Registered instance of %s", serviceId));
		discoveryClient.getInstances(serviceId).forEach(this::logServiceInstance);
	}
	
	private void logServiceInstance(ServiceInstance serviceInstance) {
		String message = String.format(">>>Host: %s, Port: %s, ServiceId: %s", 
				serviceInstance.getHost(), 
				serviceInstance.getPort(), 
				serviceInstance.getServiceId());
		log.info(message);
	}

}
