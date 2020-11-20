package com.projet.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

import com.projet.beans.Disponibilite;
import com.projet.beans.Employee;
import com.projet.jwt.JwtUserDetails;
import com.projet.repositories.DisponibiliteRepo;
import com.projet.repositories.EmployeeRepo;
import com.projet.services.DisponibiliteImpl;

@RestController
public class DisponibiliteController {

	@Autowired
	private DisponibiliteImpl dispImpl;
	@Autowired
	private DisponibiliteRepo dispRep;
	@Autowired
	private EmployeeRepo empRep;
	
	
	@GetMapping("/disponibilite")
	public Set<Disponibilite> allDispo() {
		return dispImpl.allDisp();
	}
	
	@GetMapping("/disponibilite/{id}")
	public Optional<Disponibilite> getDispo(@PathVariable int id,Model model) {
		Optional<Disponibilite> disp = dispRep.findById(id);
		
		return disp;
	    			
	}
	@GetMapping("/isDisponibilite")
	public String isDispo() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof JwtUserDetails) {
		  int id = ((JwtUserDetails)principal).getId();
		  System.out.println("is id"+id);
		  String isDisp = empRep.findDispo(id);
		  System.out.println(isDisp);
		  String t = String.valueOf(isDisp);
		  System.out.println(t);	  
		  return isDisp;
		} 
	
			return null;
		

	}
	@GetMapping("/dispInHor")
	public Disponibilite dispInHor(@RequestParam int idUC) {
		return dispRep.findDispInHorCreate(idUC);
	}
	
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/disponibilite/{id}")
	public Disponibilite upDisp(@RequestBody Disponibilite disp) {	
		Optional<Disponibilite> dispo = dispRep.findById(disp.getIdDispo());
		Employee emp = dispo.get().getEmployeeFromDisp();
		
		System.out.println("l employee est "+dispo.get().getEmployeeFromDisp());
		disp.setEmployeeFromDisp(emp);
		
		return dispRep.save(disp);
	}
	@PostMapping("/addDispo")
	public Disponibilite addDisp(@RequestBody Disponibilite disp ) {	
	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof JwtUserDetails) {
		  int idd = ((JwtUserDetails)principal).getId();
		  Optional<Employee> emp = empRep.findById(idd);
		  int idUser = emp.get().getIdEmploye();
		  Employee emp2 = new Employee();
		  emp2.setIdEmploye(idUser);
		  disp.setEmployeeFromDisp(emp2);
		} 
		
		return dispRep.save(disp);
	}
	
	
}
