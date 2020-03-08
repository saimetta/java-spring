package com.santiago.aimetta.model;

import java.util.List;

public class UserRating {

	private List<Rating> userRatings;


	public UserRating(List<Rating> userRatings) {
		super();
		this.userRatings = userRatings;
	}

	public List<Rating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}
	
	
	
	
}
