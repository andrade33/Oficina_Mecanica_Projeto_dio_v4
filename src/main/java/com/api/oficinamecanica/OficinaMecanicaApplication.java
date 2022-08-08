package com.api.oficinamecanica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.api.oficinamecanica.entity"})
@SpringBootApplication
public class OficinaMecanicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OficinaMecanicaApplication.class, args);
	}
}
