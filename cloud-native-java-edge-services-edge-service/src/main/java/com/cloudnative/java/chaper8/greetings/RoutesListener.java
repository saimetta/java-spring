package com.cloudnative.java.chaper8.greetings;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.event.HeartbeatEvent;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RoutesListener {

	private final RouteLocator routeLocator;
	private final DiscoveryClient discoveryClient;
	private Log log = LogFactory.getLog(getClass());
	
	public RoutesListener(RouteLocator routeLocator, DiscoveryClient discoveryClient) {
		this.routeLocator = routeLocator;
		this.discoveryClient = discoveryClient;
	}
	
	@EventListener(HeartbeatEvent.class)
	public void onHeartbeatEvent(HeartbeatEvent heartbeatEvent) {
		log.info(">>>>onHeartbeatEvent");
		discoveryClient.getServices().stream().map( service -> service.toString()).forEach(log::info);
	}
	
	@EventListener(RoutesRefreshedEvent.class)
	public void onRoutesRefreshedEvent(RoutesRefreshedEvent routesRefreshedEvent) {
		log.info(">>>>onRoutesRefreshedEvent");
		discoveryClient.getServices().stream().map( service -> service.toString()).forEach(log::info);
	}
	
}
