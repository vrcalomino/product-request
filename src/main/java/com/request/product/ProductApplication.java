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


		System.setProperty("spring.rabbitmq.host", Objects.requireNonNull(dotenv.get("RABBITMQ_HOST")));
		System.setProperty("spring.rabbitmq.port", Objects.requireNonNull(dotenv.get("RABBITMQ_PORT")));
		System.setProperty("spring.rabbitmq.username", Objects.requireNonNull(dotenv.get("RABBITMQ_USERNAME")));
		System.setProperty("spring.rabbitmq.password", Objects.requireNonNull(dotenv.get("RABBITMQ_PASSWORD")));

		SpringApplication.run(ProductApplication.class, args);
	}

}
