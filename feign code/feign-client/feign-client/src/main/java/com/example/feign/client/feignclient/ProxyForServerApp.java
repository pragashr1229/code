package com.example.feign.client.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="moviedb", url = "http://localhost:8097")
public interface ProxyForServerApp {

	  @GetMapping(path="/test1") 
	  public String callTest1();
	  
	  @GetMapping(path="/test") 
	  public String callTest();
	  
	  @GetMapping("/movies/{name}")
	  public Movie callMovieDetails(@PathVariable("name") String name);

}
