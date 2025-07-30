package training.iqgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("api/test")
@CrossOrigin
public class TestController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello, this is a test endpoint!";
	}

	@GetMapping("/status")
	public String status() {
		return "Service is up and running!";
	}
}


