package com.swamy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Ms02PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms02PaymentServiceApplication.class, args);
	}

}
