package com.projet.controllers;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Employee;
import com.projet.jwt.JwtUserDetails;
import com.projet.repositories.EmployeeRepo;
import com.projet.services.EmployeeImpl;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeImpl empImp;
	@Autowired
	private EmployeeRepo empRep;
	
	@GetMapping("/employee")
	public Set<Employee> allEmployee(Model model) {
		return empImp.findAll();
	}
	@PostMapping("/register")
	public Employee register(@RequestBody Employee emp) {
		return empImp.addEmp(emp);
		
	}
	
	@GetMapping("/currentUser")
	public String currentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof JwtUserDetails) {
		  int id = ((JwtUserDetails)principal).getId();
		 Optional<Employee> emp = empRep.findById(id);
		 Employee emp2 = emp.get();
		 String nom = emp2.getNom();
		 
		  	  
		  return nom ;
		} 
	
			return null;
		

	}
	@GetMapping("/empForSchedule")
	public Employee getThis(@RequestParam String id){
		return empRep.employeOfSchedule(id);
	}
	@GetMapping("/employeOnId/{id}")
	public Optional<Employee> getEmpWithId(@PathVariable int id) {
		return empRep.findById(id);
	}
	
}
