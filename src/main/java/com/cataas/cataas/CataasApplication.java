package com.cataas.cataas;

import com.cataas.cataas.model.Cat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CataasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CataasApplication.class, args);
	}
}
