package com.swamy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Ms01EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms01EurekaServerApplication.class, args);
	}

}
