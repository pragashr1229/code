package com.spring.security.examples.springsecurityapp1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
	
	@GetMapping("/message")
	public String getMessage() {
		return " From JWT Application !!";
	}
	
	@GetMapping
	public String getMessage1() {
		return " From JWT Application !!";
	}

}
