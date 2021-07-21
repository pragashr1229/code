package com.example.feign.client.feignclient;

public class Movie {
	
	private String name;
	private String release_date;
	private String message;
	
	
	
	@Override
	public String toString() {
		return "Movie [name=" + name + ", release_date=" + release_date + ", message=" + message + "]";
	}
	public Movie(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public Movie(String name, String release_date) {
		super();
		this.name = name;
		this.release_date = release_date;
	}
	
	

}
