package com.security.example.springsecurityapp2;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements UserDetailsService{
	
	@Autowired
	private PersonRepo personRepo;

	Logger logger = LoggerFactory.getLogger(PersonService.class);
	
	// Method will be called by the spring security component
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.info("Inside loadUserByUsername");
		Person person = personRepo.findById(username).get();
		
		List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(person.getRole()));
		
		UserDetails user = new User(username,person.getPassword(),roles);
		
		return user;
	}
	
	
	public Person save(Person person) {
		
		personRepo.save(person);
		return person;
	
	}
}
