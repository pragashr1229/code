package com.example.moviedb;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieCOntroller {
	
	@GetMapping("/movies/{name}")
	public Movie getMovieDetails(@PathVariable String name ) {
		
		List<Movie> movieList = Arrays.asList(new Movie("titan", "08-01-1994"),new Movie("Avatar", "08-01-2009"));
		
		for(Movie movie : movieList) {
			if(movie.getName().equalsIgnoreCase(name)) {
				return movie;
			}
		}
		
		return new Movie("Movie Not FOund");
		
	}
	
	@GetMapping("/test")
	public String getTest() {
		return "Message From Test EndPoint";
	}
	
	@GetMapping("/test1")
	public String getTest1() {
		return "Message From Test1 EndPoint";
	}

}
