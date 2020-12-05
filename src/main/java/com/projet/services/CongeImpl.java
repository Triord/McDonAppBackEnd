package com.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.projet.beans.Conge;
import com.projet.beans.Employee;
import com.projet.jwt.JwtUserDetails;
import com.projet.repositories.CongeRepo;
import com.projet.repositories.EmployeeRepo;

@Service
public class CongeImpl {

	@Autowired
	private CongeRepo congeR;
	@Autowired
	private EmployeeRepo empR;
	
	public List<Conge> findAll(){
		List<Conge> congeList = congeR.allConge();
		return congeList;
	}
	public Conge acceptConge(Conge con) {
		int idC = con.getIdConge();
		Conge congeInDb = congeR.findById(idC).get();
		con.setStatusConge(true);
		congeInDb.setStatusConge(con.isStatusConge());
		return congeR.save(congeInDb);
	}
	public Conge unacceptConge(Conge con) {
		int idC = con.getIdConge();
		Conge congeInDb = congeR.findById(idC).get();
		con.setStatusConge(false);
		congeInDb.setStatusConge(con.isStatusConge());
		return congeR.save(congeInDb);
	}
	public Conge demandeDeConge(Conge con) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int id = ((JwtUserDetails)principal).getId();
		Employee emp = empR.findById(id).get();
		con.setEmployeeFromConge(emp);
		return congeR.save(con);
	}
}
