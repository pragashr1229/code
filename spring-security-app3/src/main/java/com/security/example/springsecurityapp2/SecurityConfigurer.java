package com.security.example.springsecurityapp2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
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

		http
		.csrf().disable()
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.httpBasic()
		.and()
		.formLogin();
		
	  }
	  
	  @Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}
	 
}