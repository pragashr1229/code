package com.security.example.springsecurityapp2;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {
	
	@PostMapping("/message1")
	public MyResponse getMessage1() {
		return new MyResponse(" From  getMessage1");
	}

	@GetMapping("/message2")
	public MyResponse getMessage2() {
		return new MyResponse(" From  getMessage2");
	}
	
	@GetMapping("/message3")
	public MyResponse getMessage3() {
		return new MyResponse(" From  getMessage3");
	}
	@GetMapping("/message4")
	public MyResponse getMessage4() {
		return new MyResponse(" From  getMessage4");
	}
	@GetMapping("/")
	public MyResponse getMessage() {
		return new MyResponse(" From  getMessage");
	}	
}
