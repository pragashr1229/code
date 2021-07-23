package com.example.HelloDocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String getTest() {
		return "Welcome To DOCKER !!!";
	}
}
