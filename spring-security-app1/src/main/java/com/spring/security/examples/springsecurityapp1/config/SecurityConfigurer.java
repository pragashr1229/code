
 package com.spring.security.examples.springsecurityapp1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity 
public class SecurityConfigurer extends WebSecurityConfigurerAdapter{
 
 @Override 
 protected void configure(HttpSecurity http) throws Exception {
 

http.authorizeRequests()
		.antMatchers("/").hasRole("ADMIN")
		.antMatchers("/message1").hasRole("ADMIN")
		.antMatchers("/message2").hasRole("USER")
		.and()
		.httpBasic()
		.and()
		.formLogin();
 }
 
 
	
	/*
	 * @Bean public PasswordEncoder getPassEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */ 
	 
 @Bean
  public PasswordEncoder getPassEncoder() { 
	  return new BCryptPasswordEncoder();
  }
 
 @Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
 
 
 }
