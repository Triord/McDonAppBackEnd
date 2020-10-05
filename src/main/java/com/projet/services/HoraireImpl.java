package com.projet.services;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.projet.beans.Conge;
import com.projet.beans.Employee;
import com.projet.beans.Horaire;
import com.projet.jwt.JwtUserDetails;
import com.projet.repositories.CongeRepo;
import com.projet.repositories.EmployeeRepo;
import com.projet.repositories.HoraireRepo;

@Service
public class HoraireImpl implements HoraireService{

	@Autowired
	private HoraireRepo horRep;
	
	@Autowired
	private EmployeeRepo empRep;
	@Autowired
	private CongeRepo congRep;
	
	public Set<Horaire> findAll(){
		Set<Horaire> horaire = new HashSet<Horaire>((Collection<Horaire>) horRep.findAll()); 
		return horaire;
		}
	public Horaire createScheduleDayperDay(Horaire h) throws Exception {
		  
		
		
		
		Employee emp = h.getEmployee();
		empRep.findById(emp.getIdEmploye());
		int idEmp = emp.getIdEmploye();
		System.out.println(emp.getEmail());
		Date dtHoraire = h.getDateJour();
		
		
		System.out.println(h.getDateJour());
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("yyyy-MM-dd");
		
	    System.out.println(formater.format(h.getDateJour()));
	    String t = formater.format(h.getDateJour());
	   
		Conge conge = congRep.findConge(idEmp,t);
		
		if (conge != null || emp.isStatut() == false)throw new Exception("un conge ce jour la");
		else {
		System.out.println("pas de conge ce jour la");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof JwtUserDetails) {
			  int id = ((JwtUserDetails)principal).getId();
			  System.out.println("id user co is"+id);
			  Optional<Employee> createdSch =empRep.findById(id);
			  h.setCreateBy(createdSch.get());
			  h.setModifBy(createdSch.get());
		}
		System.out.println(h.getCreateBy().getEmail());
		h.getHeureDebut().setSeconds(0);
		horRep.save(h);
		}
	
	   
	   
	   

		/*System.out.println(conge.getDateConge());
		
		String dateConge = conge.getDateConge().toLocaleString();
		String dateHoraire = h.getDateJour().toLocaleString();
		System.out.println(dateConge);
		System.out.println(dateHoraire);

		dateConge = dateConge.substring(0,13);
		dateHoraire = dateHoraire.substring(0,13);
		
		System.out.println(dateConge.compareTo(dateHoraire));
		
		if (dateHoraire.compareTo(dateConge) == 0) {
			System.out.println("jour pas dispo");
		}
		*/
		
	  
		
		 return h;
	}
}

