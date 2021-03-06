package com.kbtg.hackathon.fruitmark.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@RequestMapping("/")
	public String index(@RequestBody String body, @RequestHeader HttpHeaders headers) {
		System.out.println("Call SampleController");
		return "Hello World!";
	}
	
}
