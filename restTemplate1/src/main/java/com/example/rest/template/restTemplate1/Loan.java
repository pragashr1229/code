package com.example.rest.template.restTemplate1;

public class Loan {
	
	private Long id;
	private String name;
	private Long loanAmount;
	
	
	
	public Loan() {
		super();
	}
	public Loan(Long id, String name, Long loanAmount) {
		super();
		this.id = id;
		this.name = name;
		this.loanAmount = loanAmount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}
}
