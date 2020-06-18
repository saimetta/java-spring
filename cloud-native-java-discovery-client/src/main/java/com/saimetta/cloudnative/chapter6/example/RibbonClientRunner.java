package com.saimetta.cloudnative.chapter6.example;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;

@Component
public class RibbonClientRunner implements ApplicationRunner{

	private final DiscoveryClient discoveryClient;
	private final Log log = LogFactory.getLog(getClass());
	@Value("${spring.application.name}")
	private String serviceId;
	
	public RibbonClientRunner(DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		/**
		 * Generate a list of server instances using the discoveryClient to find the available
		 * host info for the service id
		 */
		List<Server> servers = discoveryClient.getInstances(serviceId)
				.stream().map( serviceInstance -> 
				new Server(serviceInstance.getHost(), serviceInstance.getPort()))
				.collect(Collectors.toList());
		
		
		/**
		 * Load balance using RoundRobin, you'll get the same result using a restTemplate annotated
		 * with @LoadBalanced
		 */
		IRule roundRobinRule = new RoundRobinRule();
		BaseLoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder()
				.withRule(roundRobinRule).buildFixedServerListLoadBalancer(servers);
		

		
		/**
		 * Find and enumerate the service instances
		 */
		IntStream.range(0, 10).forEach( i -> {
			Server server = loadBalancer.chooseServer();
			Optional.of(server).ifPresent( s -> {
				URI uri = URI.create(String.format("http://%s:%s/", s.getHost(),s.getPort()));
				log.info(String.format(">>>>>>>RibbonClientRunner resolved service :%s", uri.toString()));
			});
		});

		
	}

}
