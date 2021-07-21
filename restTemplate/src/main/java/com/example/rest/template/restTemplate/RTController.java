package com.example.rest.template.restTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RTController {
	
	private final String REQUEST_URI1 ="http://localhost:8081/rt1";
	private final String GET_LOAN_DETAILS_URI ="http://localhost:8081/loan";
	private final String VERIFY_ELIGIBILITY_URI ="http://localhost:8082/loan";

	Logger LOG = LoggerFactory.getLogger(RTController.class);
	
	@RequestMapping("/loan/{id}")
	public String getLoanDetails(@PathVariable Long id) {
		
		  LOG.info("ID : " + id);

		  RestTemplate restTemplate = new RestTemplate();
		  ResponseEntity<Loan> loanDetails = restTemplate.getForEntity(GET_LOAN_DETAILS_URI + "/"+id,
		                                                              Loan.class);
		  LOG.info("Status code value: " + loanDetails.getStatusCodeValue());
		  LOG.info("HTTP Header 'ContentType': " + loanDetails.getHeaders().getContentType());
		  
		  ResponseEntity<Boolean> flag = restTemplate.getForEntity(VERIFY_ELIGIBILITY_URI + "/"+loanDetails.getBody().getLoanAmount(),
				  Boolean.class);
		  
		  if(flag.getBody().booleanValue())
			  return "Eligible";
		  
		  return "Not Eligible";
		}
	
	@RequestMapping("/rt/{value}")
	public ResponseEntity<String> getTemplateMessage(@PathVariable String value) {
		
		RestTemplate restTemplate = new RestTemplate();
		  ResponseEntity<String> entity = restTemplate.getForEntity(REQUEST_URI1 + "/"+value,
		                                                              String.class);
		  LOG.info("Status code value: " + entity.getStatusCodeValue());
		  LOG.info("HTTP Header 'ContentType': " + entity.getHeaders().getContentType());
		  return entity;
		}
}
