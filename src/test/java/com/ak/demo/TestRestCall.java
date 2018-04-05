package com.ak.demo;

import org.springframework.web.client.RestTemplate;

public class TestRestCall {
	
	public static void main(String args[]) {
		RestTemplate restTemplate = new RestTemplate();
		String result = 
				restTemplate.getForObject(
				    "http://localhost:8090/positions-test?fund_code={code}",
				    String.class,"00200"
				);
		
		System.out.println("Result:" + result);
	}
}
