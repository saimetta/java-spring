package com.santiago.aimetta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.santiago.aimetta.model.CatalogItem;
import com.santiago.aimetta.model.Movie;
import com.santiago.aimetta.model.Rating;

@Service
public class MovieInfoService {

	
	@Value("${moviesInfo.api.url}")
	private String moviesInfoApiUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand( 
			//Circuit breaker properties
			fallbackMethod = "getFallbackCatalogItem",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
			},
			//Bulkhead properties
			threadPoolKey = "movieIntoPool",
			threadPoolProperties = {
					@HystrixProperty( name = "coreSize", value = "20"),//Pool size, total threads
					@HystrixProperty( name = "maxQueueSize", value = "10"),//max amount of request to be queued to wait in case all the  threads in the pool were taken
			}
			)
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject(moviesInfoApiUrl+rating.getMovieId(), Movie.class);		
		return new CatalogItem(movie.getName(),movie.getOverview(),rating.getRating());
	}
	
	private CatalogItem getFallbackCatalogItem(Rating rating) {
		return new CatalogItem("Not found","",rating.getRating());
	}
}
