package com.example.feign.client.feignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	private ProxyForServerApp proxyForServerApp;
	
	@GetMapping(path="/hello1")
	public String hello1() {
		System.out.println("from hello1");
		
		  String results = proxyForServerApp.callTest1(); 
		  String results1=proxyForServerApp.callTest();
		 
		return "from hello1:" + results.toString();
	}
	
	@GetMapping(path="/hello2/{name}")
	public String hello2(@PathVariable("name") String name) {
		System.out.println("from hello1"); 
		Movie movie = proxyForServerApp.callMovieDetails(name);
		return "from hello1:" + movie.toString();
	}
}
