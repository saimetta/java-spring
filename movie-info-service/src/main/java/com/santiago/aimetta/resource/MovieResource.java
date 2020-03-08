package com.santiago.aimetta.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.santiago.aimetta.model.Movie;
import com.santiago.aimetta.model.MovieSummary;
import com.santiago.aimetta.service.MovieInfoService;

@RestController()
@RequestMapping("/movies")
public class MovieResource {
	
	@Autowired
	private MovieInfoService movieInfoService;
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		return movieInfoService.getMovieInfo(movieId);
	}
}
