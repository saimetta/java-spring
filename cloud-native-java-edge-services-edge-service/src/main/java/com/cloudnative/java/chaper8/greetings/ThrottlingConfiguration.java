package com.cloudnative.java.chaper8.greetings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.google.common.util.concurrent.RateLimiter;

@Profile("throttled")
@Configuration
public class ThrottlingConfiguration {

	@Bean
	RateLimiter rateLimiter() {
		//Specify the amount of request per second, in this case 1 request per 10s
		return RateLimiter.create(1.0D / 10.0D);
	}
}
