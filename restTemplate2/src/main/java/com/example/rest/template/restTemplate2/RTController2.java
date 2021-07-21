package com.example.rest.template.restTemplate2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RTController2 {
	
	Logger LOG = LoggerFactory.getLogger(RTController2.class);

	@RequestMapping("/loan/{loanAmount}")
	public Boolean checkEligibility(@PathVariable Long loanAmount) {
		
		LOG.info(" loanAmount {} ",loanAmount);
			 if(loanAmount>=300000) 
				 return false;
			 else
				 return true;	 
		}
}