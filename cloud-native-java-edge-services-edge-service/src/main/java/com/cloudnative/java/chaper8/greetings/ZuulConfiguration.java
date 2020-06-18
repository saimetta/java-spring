package com.cloudnative.java.chaper8.greetings;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableZuulProxy
public class ZuulConfiguration {

	/**
	 * The Route locator is an abstraction that is aware if a discovery client is configured
	 * @param routeLocator
	 * @return
	 */
	@Bean
	ApplicationRunner applicationRunner(RouteLocator routeLocator) {
		Log log = LogFactory.getLog(getClass());
		return args -> routeLocator.getRoutes().forEach( route -> log.info(String.format("ZuulConfiguration>>>> %s (%s) %s",route.getId(),route.getLocation(),route.getFullPath())));
	}
}
