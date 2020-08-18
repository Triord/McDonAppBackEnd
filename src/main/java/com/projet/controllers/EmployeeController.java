package com.projet.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Employee;
import com.projet.services.EmployeeImpl;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeImpl empImp;
	
	@GetMapping("/employee")
	public Set<Employee> allEmployee(Model model) {
		return empImp.findAll();
	}

}
