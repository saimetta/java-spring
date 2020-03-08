package com.santiago.aimetta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.santiago.aimetta.model.Movie;
import com.santiago.aimetta.model.MovieSummary;

@Service
public class MovieInfoService {
	
	@Value("${moviedb.api.key}")
	private String apiKey;
	@Value("${moviedb.api.url}")
	private String moviesApiURL;

	@Autowired
	private RestTemplate restTemplate;
	
	
	@HystrixCommand( 
			fallbackMethod = "getFallbackMovieInfo",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
			})
	public Movie getMovieInfo(String movieId) {
		MovieSummary movieSummary = restTemplate.getForObject(moviesApiURL+movieId+"?api_key="+apiKey, MovieSummary.class);
		return new Movie(movieId, movieSummary.getTitle(),movieSummary.getOverview());
	}
	
	public Movie getFallbackMovieInfo(String movieId) {
		return new Movie(movieId, "No movie","");
	}
}
