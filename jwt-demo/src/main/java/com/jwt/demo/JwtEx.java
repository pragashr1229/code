package com.jwt.demo;

import java.security.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtEx {

	public static void main(String[] args) {
		
		
		String SecretKey = "HG%&";
		// Generate a Token
		
		JwtBuilder builder = Jwts.builder()
		.setId("A2454")
		.setIssuer("TestIssuer")
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1)))
		.signWith(SignatureAlgorithm.ES256, SecretKey.getBytes());
		
		String generateToken = builder.compact();
		
		System.out.println("Token ==>"+builder.compact());
		
		// Read /Parse the Token
		Claims claims = Jwts.parser()
				.setSigningKey(SecretKey.getBytes())
				.parseClaimsJws(generateToken)
				.getBody();
		
		System.out.println(claims.getId());
		System.out.println(claims.getIssuer());
		System.out.println(claims.getIssuedAt());
		
		

	}

}
