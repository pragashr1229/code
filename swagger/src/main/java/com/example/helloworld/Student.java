package com.example.helloworld;

import org.springframework.stereotype.Component;

@Component
public class Student {
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
