package com.example.service2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service2Controller {
	
	@GetMapping("/add/{input1}/{input2}")
	public Integer additionOFTwoNumbers(@PathVariable("input1") int input1,@PathVariable("input2") int input2) {
		return input1 + input2;
	}
	@GetMapping("/multiply/{input1}/{input2}")
	public Integer multiplyOFTwoNumbers(@PathVariable("input1") int input1,@PathVariable("input2") int input2) {
		return input1 * input2;
	}
	@GetMapping("/substract/{input1}/{input2}")
	public Integer substractOFTwoNumbers(@PathVariable("input1") int input1,@PathVariable("input2") int input2) {
		return input1 - input2;
	}
}
