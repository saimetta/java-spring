package com.santiago.aimetta.resource;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.aimetta.model.Rating;
import com.santiago.aimetta.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 7);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		return new UserRating(Arrays.asList(
				new Rating("100", 7),
				new Rating("205", 8)
		));
	}
}
