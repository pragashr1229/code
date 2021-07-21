package com.example.rest.template.restTemplate1;

import java.util.Arrays;
import java.util.List;
 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RTController1 {
	
	@RequestMapping("/rt1/{value}")
	public String getTemplateMessage(@PathVariable String value) {
		
		return value + " Returned From Service2" ;
	}
	
	@RequestMapping("/loan/{id}")
	public Loan getLoanDetails(@PathVariable Long id) {
			List<Loan> loanList = Arrays.asList(new Loan(1L,"Rajesh",300000L),new Loan(2L,"Ramesh",2500000L));
			for(Loan loan : loanList) {
				if(loan.getId().equals(id)) {
					return loan;
				}
			}
			return null;
		}
	
	
	

}
