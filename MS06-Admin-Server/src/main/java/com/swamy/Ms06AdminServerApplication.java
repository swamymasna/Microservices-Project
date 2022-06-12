package com.swamy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class Ms06AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms06AdminServerApplication.class, args);
	}

}
