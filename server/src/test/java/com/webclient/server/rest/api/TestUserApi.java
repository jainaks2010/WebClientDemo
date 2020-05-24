package com.webclient.server.rest.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.testng.annotations.Test;

import reactor.core.publisher.Flux;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestUserApi extends AbstractTestNGSpringContextTests{
	
	@LocalServerPort
	private int port;
		
	@Autowired
	private TestRestTemplate restTemplate;
	
		
	@Test
	public void testRest() {
		System.out.println("REST Template Test");
		String url = "http://localhost:"+port+"/api/test";
		String data =restTemplate.getForObject(url, String.class);
		System.out.println("First Output:"+data);
		System.out.println("Starting second request");
		data =restTemplate.getForObject(url, String.class);
		System.out.println("Second Output:"+data);
	}
	
	@Test
	public void testWebClient() {
		System.out.println("Flux Test");
		String url = "http://localhost:"+port;
		Flux<String> flux = WebClient.create(url)
			      .get()
			      .uri("/api/test")
			      .retrieve()
			      .bodyToFlux(String.class);
		flux.subscribe(System.out::println);
		System.out.println("Starting second request");
		flux = WebClient.create(url)
			      .get()
			      .uri("/api/test")
			      .retrieve()
			      .bodyToFlux(String.class);
		flux.subscribe(System.out::println);

	}
	
	

}
