package com.jwt.demo;

import io.jsonwebtoken.Claims;

public class JwtEX1 {
	
	public static void main(String[] args) {
		JwtUtil jwtUtil = new JwtUtil();
		 String token=jwtUtil.generateToken("A234", "Subject", "JWTKey");
		
		//String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJBMjQ1NCIsImlzcyI6IlRlc3RJc3N1ZXIiLCJpYXQiOjE2MjYzNDY2MDAsImV4cCI6MTYyNjM0NjY2MH0.-_p4rpqVSyu8Gu5px9BfJfgkwLwCv9SWlsmYLXjLp5g";
		
		System.out.println("token ==>"+token);
		
		Claims c = jwtUtil.getClaims(token, "HG%&");
		
		System.out.println(c.toString());
	}

}
