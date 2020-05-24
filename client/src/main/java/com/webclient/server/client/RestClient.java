package com.webclient.server.client;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class RestClient{
		
	public void restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		String string = restTemplate.getForObject("http://localhost:8080/api/test", String.class);
		System.out.println(string);
	}
	
	public void webClient() {
		 Mono<String> bodyToMono = WebClient.create("http://localhost:8080/")
				.get()
				.uri("/api/test")
				.exchange()
				 .log()
				 .flatMap(r -> r.bodyToMono(String.class));
		 bodyToMono.subscribe(System.out::println);
	}
}
