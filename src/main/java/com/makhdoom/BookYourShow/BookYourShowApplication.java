package com.makhdoom.BookYourShow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookYourShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookYourShowApplication.class, args);
	}

}
