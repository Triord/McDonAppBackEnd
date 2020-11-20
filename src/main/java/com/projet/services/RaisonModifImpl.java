package com.projet.services;

import java.util.Date;
import java.util.Optional;

import org.apache.tomcat.util.descriptor.web.ContextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.projet.beans.Employee;
import com.projet.beans.RaisonModif;
import com.projet.jwt.JwtUserDetails;
import com.projet.repositories.EmployeeRepo;
import com.projet.repositories.RaisonModifRepo;

@Service
public class RaisonModifImpl {

	@Autowired
	private RaisonModifRepo rmRep;
	@Autowired 
	private EmployeeRepo empRep;
	
	public RaisonModif saveModif(RaisonModif rm) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int idEmpModif = ((JwtUserDetails)principal).getId();
		//System.out.println("id de celui qui modifie is"+idEmpModif);
		Employee emp = new Employee();
		emp = empRep.findById(idEmpModif).get();
		Date date = new Date();
		//System.out.println(emp.getNom()+" "+emp.getPrenom());
		rm.setEmployeFromRM(emp);
		rm.setDateModif(date);
		return rmRep.save(rm);
	}
	
}
