package com.projet.services;

import java.security.Security;
import java.util.Date;

import org.apache.tomcat.util.descriptor.web.ContextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.projet.beans.Employee;
import com.projet.beans.ViewEmploye;
import com.projet.jwt.JwtUserDetails;
import com.projet.repositories.EmployeeRepo;
import com.projet.repositories.ViewEmplRepo;

@Service
public class ViewEmplImpl {

	@Autowired
	private ViewEmplRepo veRep;
	@Autowired
	private EmployeeRepo empRep;
	
	public ViewEmploye saveRaisonView(ViewEmploye ve) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int idManaWhoViewed = ((JwtUserDetails)principal).getId();
		Employee mana = empRep.findById(idManaWhoViewed).get();
		Date dateViewed = new Date();
		ve.setDateView(dateViewed);
		ve.setManaWhoViewed(mana);
		veRep.save(ve);
		return ve;
	}
}
