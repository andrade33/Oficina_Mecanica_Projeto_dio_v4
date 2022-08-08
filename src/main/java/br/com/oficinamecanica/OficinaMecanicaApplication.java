package br.com.oficinamecanica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"br.com.oficinamecanica.entity"})
@SpringBootApplication
public class OficinaMecanicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OficinaMecanicaApplication.class, args);
	}
}
