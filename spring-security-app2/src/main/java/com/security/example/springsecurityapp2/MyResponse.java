package com.security.example.springsecurityapp2;

public class MyResponse {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MyResponse(String message) {
		this.message = message;
	}
}
