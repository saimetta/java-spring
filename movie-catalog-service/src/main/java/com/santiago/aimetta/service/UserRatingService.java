package com.santiago.aimetta.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.santiago.aimetta.model.Rating;
import com.santiago.aimetta.model.UserRating;

@Service
public class UserRatingService {

	@Autowired
	private RestTemplate restTemplate;
	@Value("${rattings.api.url}")
	private String ratingsApiURL;
	
	@HystrixCommand( 
			fallbackMethod = "getFallbackUserRating",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
			})
	public UserRating getUserRating(String userId) {
		return restTemplate.getForObject(ratingsApiURL+userId, UserRating.class);
	}
	
	private UserRating getFallbackUserRating(String userId) {
		UserRating defaultRating = new UserRating();
		defaultRating.setUserRatings(Arrays.asList(new Rating("0",0)));
		return defaultRating;
	}
}
