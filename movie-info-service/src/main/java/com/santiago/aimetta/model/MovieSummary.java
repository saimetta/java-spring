package com.santiago.aimetta.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieSummary {

	@JsonProperty("adult")
	public Boolean adult;
	@JsonProperty("backdrop_path")
	public String backdropPath;
	@JsonProperty("belongs_to_collection")
	public Object belongsToCollection;
	@JsonProperty("budget")
	public Integer budget;
	@JsonProperty("homepage")
	public String homepage;
	@JsonProperty("id")
	public Integer id;
	@JsonProperty("imdb_id")
	public String imdbId;
	@JsonProperty("original_language")
	public String originalLanguage;
	@JsonProperty("original_title")
	public String originalTitle;
	@JsonProperty("overview")
	public String overview;
	@JsonProperty("popularity")
	public Double popularity;
	@JsonProperty("poster_path")
	public String posterPath;
	@JsonProperty("release_date")
	public String releaseDate;
	@JsonProperty("revenue")
	public Integer revenue;
	@JsonProperty("runtime")
	public Integer runtime;
	@JsonProperty("status")
	public String status;
	@JsonProperty("tagline")
	public String tagline;
	@JsonProperty("title")
	public String title;
	@JsonProperty("video")
	public Boolean video;
	@JsonProperty("vote_average")
	public Double voteAverage;
	@JsonProperty("vote_count")
	public Integer voteCount;
	

	public MovieSummary() {
		
	}
	
	
	public Boolean getAdult() {
		return adult;
	}
	public void setAdult(Boolean adult) {
		this.adult = adult;
	}
	public String getBackdropPath() {
		return backdropPath;
	}
	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}
	public Object getBelongsToCollection() {
		return belongsToCollection;
	}
	public void setBelongsToCollection(Object belongsToCollection) {
		this.belongsToCollection = belongsToCollection;
	}
	public Integer getBudget() {
		return budget;
	}
	public void setBudget(Integer budget) {
		this.budget = budget;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getOriginalLanguage() {
		return originalLanguage;
	}
	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}
	public String getOriginalTitle() {
		return originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public Double getPopularity() {
		return popularity;
	}
	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}
	public String getPosterPath() {
		return posterPath;
	}
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getRevenue() {
		return revenue;
	}
	public void setRevenue(Integer revenue) {
		this.revenue = revenue;
	}
	public Integer getRuntime() {
		return runtime;
	}
	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getVideo() {
		return video;
	}
	public void setVideo(Boolean video) {
		this.video = video;
	}
	public Double getVoteAverage() {
		return voteAverage;
	}
	public void setVoteAverage(Double voteAverage) {
		this.voteAverage = voteAverage;
	}
	public Integer getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}
	
	
	
}
