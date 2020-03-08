package com.santiago.aimetta.resource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.santiago.aimetta.model.CatalogItem;
import com.santiago.aimetta.model.Rating;
import com.santiago.aimetta.model.UserRating;
import com.santiago.aimetta.service.MovieInfoService;
import com.santiago.aimetta.service.UserRatingService;

@RestController
public class MovieCatalogResource {

	
	@Autowired
	private MovieInfoService movieInfoService;
	
	@Autowired 
	private UserRatingService  userRatingService;
	
//	@Autowired
//	private WebClient.Builder webClientBuilder;
//	
	
	//Circuit breaker that when fails executes getFallbackCatalog
	@HystrixCommand( fallbackMethod = "getFallbackCatalog")
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId")String userId) {
		
		//Get the movies ids list for the user
		
		//Get the movies ratings
		UserRating userRatings = userRatingService.getUserRating(userId);
		
		Function<Rating, CatalogItem> getCatalogItem = rating -> {
			
			// Alternative way using WebClient, uses something like promises (reactive programming) async programming
//			Movie movie = webClientBuilder.build()
//							.get()
//							.uri("http://localhost:8082/movies/"+rating.getMovieId())
//							.retrieve()
//							.bodyToMono(Movie.class)
//							.block();
			
			return movieInfoService.getCatalogItem(rating);
		};
		
		//Merge all and return
		return userRatings.getUserRatings().stream().map( getCatalogItem ).collect(Collectors.toList());
		
	}
	
	

	
	public List<CatalogItem> getFallbackCatalog(@PathVariable("userId")String userId) {
		return Arrays.asList(new CatalogItem("No movie", "", 0));
	}
}
