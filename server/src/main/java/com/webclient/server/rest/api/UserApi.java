package com.webclient.server.rest.api;

import java.time.Duration;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class UserApi {

	@GetMapping(path = "/test")
	public String test() {
		System.out.println("Test Request Started");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Test Request Ended");

		return "OK";
	}
	
	@GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> flux(){
		return Flux.interval(Duration.ofSeconds(1L)).map(v -> new String((new Date()).toString()));
	}

}
