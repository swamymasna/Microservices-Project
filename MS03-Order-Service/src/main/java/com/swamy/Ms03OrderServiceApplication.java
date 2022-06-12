package com.swamy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class Ms03OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms03OrderServiceApplication.class, args);
	}

}
