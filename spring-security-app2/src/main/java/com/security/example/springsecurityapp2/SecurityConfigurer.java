package com.security.example.springsecurityapp2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private PersonService personService;

	Logger logger = LoggerFactory.getLogger(SecurityConfigurer.class);

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("Inside configure method of SecurityConfigurer class ");
		auth.userDetailsService(personService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.csrf().disable()
		.authorizeRequests()
		  .antMatchers("/").hasRole("ADMIN")
		  .antMatchers("/message1").hasAnyRole("ADMIN","USER")
		  .antMatchers("/message2").hasRole("USER") 
		 // .anyRequest().authenticated()
		  .and() 
		  .httpBasic() 
		  .and()
		  .formLogin(); 
		
	}
	
	
}