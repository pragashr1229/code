package com.spring.security.examples.springsecurityapp1;

public class JwtResponse {

	private String jwtToken;

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public JwtResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}
	
	
}
