package com.example.feign.client.feignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.example.feign.client.feignclient")
public class FeignClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}
}