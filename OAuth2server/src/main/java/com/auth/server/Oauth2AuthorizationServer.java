package com.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Oauth2AuthorizationServer {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2AuthorizationServer.class, args);
	}

}
