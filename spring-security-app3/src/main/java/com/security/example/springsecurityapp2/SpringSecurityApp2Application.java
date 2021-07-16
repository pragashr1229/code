package com.security.example.springsecurityapp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityApp2Application implements CommandLineRunner{
	
	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApp2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person p = new Person();
		p.setUsername("user1");
		p.setPassword(getPasswordEncoder().encode("xyz"));
		p.setRole("ROLE_ADMIN");
		
		Person p1 = new Person();
		p1.setUsername("user2");
		p1.setPassword(getPasswordEncoder().encode("xyz"));
		p1.setRole("ROLE_USER");
		
		personService.save(p);
		personService.save(p1);
	}
	
	@Bean
		public PasswordEncoder getPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}
}
