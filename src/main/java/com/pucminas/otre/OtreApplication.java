package com.pucminas.otre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.pucminas.otre.model"})
@EnableJpaRepositories(basePackages = {"com.pucminas.otre.repositories"})
public class OtreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtreApplication.class, args);
	}

}
