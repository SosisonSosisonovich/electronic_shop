package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
@EnableJpaRepositories("com.example.backend.Repositories")
public class BackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
