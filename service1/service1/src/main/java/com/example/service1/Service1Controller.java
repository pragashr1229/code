package com.example.service1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Service1Controller {
	
	RestTemplate restTemplate = new RestTemplate();
	
	private final String request_uri ="http://localhost:8080/";
	
	@GetMapping("/add/{input1}/{input2}")
	public ResponseEntity<Integer> performAddoperation(@PathVariable("input1") Integer input1,
			@PathVariable("input2") Integer input2 ) {
		ResponseEntity<Integer> result = restTemplate.getForEntity(request_uri+"/add"+"/"+input1+"/"+input2, Integer.class);
		
		return result;
	}
	@GetMapping("/multiply/{input1}/{input2}")
	public ResponseEntity<Integer> performmultiplyoperation(@PathVariable("input1") Integer input1,
			@PathVariable("input2") Integer input2 ) {
		ResponseEntity<Integer> result = restTemplate.getForEntity(request_uri+"/multiply"+"/"+input1+"/"+input2, Integer.class);
		return result;
	}
	@GetMapping("/substract/{input1}/{input2}")
	public ResponseEntity<Integer> performSubstractoperation(@PathVariable("input1") Integer input1,
			@PathVariable("input2") Integer input2 ) {
		ResponseEntity<Integer> result = restTemplate.getForEntity(request_uri+"/substract"+"/"+input1+"/"+input2, Integer.class);
		return result;
	}
	

}
