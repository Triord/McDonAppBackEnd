package com.projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.projet.beans.Employee;
@SpringBootApplication
public class ProjetMcDonaldsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetMcDonaldsApplication.class, args);
	}

}
