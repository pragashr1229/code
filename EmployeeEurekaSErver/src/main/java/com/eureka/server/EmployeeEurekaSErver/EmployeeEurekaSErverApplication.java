package com.eureka.server.EmployeeEurekaSErver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EmployeeEurekaSErverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeEurekaSErverApplication.class, args);
	}

}
