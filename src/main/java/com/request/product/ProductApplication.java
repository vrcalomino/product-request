package com.request.product;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();

		System.setProperty("spring.datasource.username", Objects.requireNonNull(dotenv.get("MYSQL_USER")));
		System.setProperty("spring.datasource.password", Objects.requireNonNull(dotenv.get("MYSQL_PASSWORD")));
		System.setProperty("spring.datasource.url", Objects.requireNonNull(dotenv.get("MYSQL_URL")));
		SpringApplication.run(ProductApplication.class, args);
	}

}
