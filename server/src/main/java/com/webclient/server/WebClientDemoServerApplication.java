package com.webclient.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.webclient.server.rest.api")
public class WebClientDemoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebClientDemoServerApplication.class, args);
	}

}
