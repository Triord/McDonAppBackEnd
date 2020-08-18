package com.projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.projet.beans.Employee;
@SpringBootApplication
public class ProjetMcDonaldsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetMcDonaldsApplication.class, args);
		Employee em = new Employee();
		
		System.out.println(em.getEmail());
	}

}
