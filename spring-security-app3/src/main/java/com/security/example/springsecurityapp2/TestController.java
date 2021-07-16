package com.security.example.springsecurityapp2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.ExpiredJwtException;

@RestController
@CrossOrigin
public class TestController {
	
	Logger log = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PersonService personService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken
	(@RequestBody JwtRequest authenticationRequest) 
			 {
		log.info("Inside authenticate endpoint");
		authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());
		final UserDetails userDetails = personService.loadUserByUsername(authenticationRequest.getUserName());
		final String token = jwtTokenUtil.generateToken(userDetails);
		log.info(token);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) {
		try {
			log.info("Starting authentication process, username {} , password {} ",username,password);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			log.info("Authentication is successful");
		} catch (DisabledException e) {
			//throw new AuthorizationException("USER_DISABLED");
		} catch (BadCredentialsException e) {
			//throw new AuthorizationException("INVALID_CREDENTIALS");
		}
	}
	@PostMapping(value = "/authorize")
	public boolean authorizeTheRequest(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) {
		System.out.println("Inside authorize ==============" + requestTokenHeader);
		String jwtToken = null;
		String userName = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			System.out.println("JWT Tocken =======================" + jwtToken);
			try {
				userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException | ExpiredJwtException e) {
				return false;
			}
		}
		return userName != null;

	}
}
