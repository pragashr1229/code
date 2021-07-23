package com.example.helloworld;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@RestController
public class HelloWorldApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(HelloWorldApplication.class, args);
		Student s = (Student)ctx.getBean("student");
		System.out.println("ID : "+s.getId());
	}
	
	@GetMapping("/test")
	public String getMessage() {
		return "Hello Swagger";
	}

}
