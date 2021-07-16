package com.spring.security.examples.springsecurityapp1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.examples.springsecurityapp1.JwtRequest;
import com.spring.security.examples.springsecurityapp1.JwtResponse;

@RestController
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	Logger log = LoggerFactory.getLogger(AuthController.class);
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken
	(@RequestBody JwtRequest authenticationRequest) 
			 {

		authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());
		//final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		//final String token = jwtTokenUtil.generateToken(userDetails);
		//log.info(token);
		return ResponseEntity.ok(new JwtResponse(""));
	}
	
	private void authenticate(String username, String password) {
		try {
			log.info("Starting authentication process");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			log.info("Authentication is successful");
		} catch (DisabledException e) {
			//throw new AuthorizationException("USER_DISABLED");
		} catch (BadCredentialsException e) {
			//throw new AuthorizationException("INVALID_CREDENTIALS");
		}
	}
	
	

}
