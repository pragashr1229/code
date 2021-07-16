package com.jwt.demo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
	//1. Generate Token 
	public String generateToken(String id, String subject, String key) {
		
		return Jwts.builder()
		.setId(id) 
		.setSubject(subject)  
		.setIssuer("TestIssuer")
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
		.signWith(SignatureAlgorithm.HS256, key.getBytes())
		.compact(); 
	}
	
	//2. Get Claims
	public Claims getClaims(String generatedToken,String secretKey) {
		return Jwts.parser()
		.setSigningKey(secretKey.getBytes())
		.parseClaimsJws(generatedToken)
		.getBody();
	} 

	// 3. 
}
