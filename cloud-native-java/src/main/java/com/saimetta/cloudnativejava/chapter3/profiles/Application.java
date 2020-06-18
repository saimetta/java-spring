package com.saimetta.cloudnativejava.chapter3.profiles;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;


@Configuration
public class Application {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Bean
	static PropertySourcesPlaceholderConfigurer pspc() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Configuration
	@Profile("prod")
	@PropertySource("prod.properties")
	public static class ProdConfiguration {
		
		@Bean
		InitializingBean init() {
			return () -> LogFactory.getLog(getClass()).info("Prod initializing");
		}
	}
	
	@Configuration
	@Profile({"default","dev"})
	@PropertySource("dev.properties")
	public static class DefaultConfiguration {
		
		@Bean
		InitializingBean init() {
			return () -> LogFactory.getLog(getClass()).info("Default initializing");
		}
	}
	
	@Bean
	InitializingBean which(Environment e,@Value("${configuration.projectName}") String projectName) {
		return () -> {
			log.info("activeProfiles: '" + StringUtils.arrayToCommaDelimitedString(e.getActiveProfiles()) + "'");
			log.info("configuration.projectName: " + projectName);
		};
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.getEnvironment().setActiveProfiles("prod");
		//ac.getEnvironment().setActiveProfiles("dev"); will change and consume the props from the default.properties
		ac.register(Application.class);
		ac.refresh();
	}

}
