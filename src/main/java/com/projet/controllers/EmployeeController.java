package com.projet.controllers;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Employee;
import com.projet.jwt.JwtUserDetails;
import com.projet.repositories.EmployeeRepo;
import com.projet.repositories.RoleRepo;
import com.projet.services.EmployeeImpl;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeImpl empImp;
	@Autowired
	private EmployeeRepo empRep;
	@Autowired
	private RoleRepo roleRep;
	
	
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
		 String prenom= emp2.getPrenom();
		 
		  	  
		  return nom+" "+prenom ;
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
	@GetMapping("/beAChief")
	public void promInChiefs(@RequestParam String idEmp){
		roleRep.beAChief(idEmp);
	}	
	@GetMapping("/beAManager")
	public void promInMana(@RequestParam String idEmp){
		roleRep.beAManager(idEmp);
	}
	@GetMapping("/beAWorker")
	public void promInWorker(@RequestParam String idEmp){
		roleRep.beAWorker(idEmp);
	}
	@GetMapping("/beAStudent")
	public void promInStudent(@RequestParam String idEmp){
		roleRep.beAStudent(idEmp);
	}
	@GetMapping("/testMethod2")
	public Object testMeth(@RequestParam String idEmp) {
		return roleRep.allinfo(idEmp);
	}
	@GetMapping("/getIdCurrentUser")
	public int getIdCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int id = ((JwtUserDetails)principal).getId();
		return id;
	}
	@CrossOrigin(origins = "http://127.0.0.1/:4200")
	@PutMapping("/changeInDispo")
	public Employee changeInDispo(@RequestBody Employee emp){
		empImp.changeStatusOnDispo(emp);
		return emp;
	}
	
	@CrossOrigin(origins = "http://127.0.0.1/:4200")
	@PutMapping("/changeInIndispo")
	public Employee changeInIndispo(@RequestBody Employee emp){
		empImp.changeStatusOnIndispo(emp);
		return emp;
	}
	@CrossOrigin(origins = "http://127.0.0.1/:4200")
	@PutMapping("/changePassword")
	public Employee changePassword(@RequestBody Employee emp){
		empImp.changePassword(emp);
		return emp;
	}
	@CrossOrigin(origins = "http://127.0.0.1/:4200")
	@PutMapping("/changeNbrHeure")
	public Employee changeNbrHeure(@RequestBody Employee emp) {
		return empImp.changeNbrHeure(emp);
	}
	
	
	
	
}
