package com.webclient.server.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class WebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebClientApplication.class, args);
		RestClient restClient = new RestClient();
		System.out.println("Testing with Webclient");
		restClient.webClient();
		System.out.println("Testing with RestTemplate");
		restClient.restTemplate();
	}

}
