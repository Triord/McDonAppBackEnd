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
import com.projet.beans.RaisonModif;
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
		Employee emp = h.getEmployeeFromHoraire();
		empRep.findById(emp.getIdEmploye());
		int idEmp = emp.getIdEmploye();
		Date dtHoraire = h.getDateJour();
		
		
		System.out.println(h.getDateJour());
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("yyyy-MM-dd");
		
	    String t = formater.format(h.getDateJour());
	   
		Conge conge = congRep.findConge(idEmp,t);
		
		if (conge != null || emp.isStatut() == false)throw new Exception("un conge ce jour la");
		else {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			 int id = ((JwtUserDetails)principal).getId();
			 Optional<Employee> createdSch =empRep.findById(id);
			 h.setStatusHoraire(true);
			 h.setCreateBy(createdSch.get());
			 h.setModifBy(createdSch.get());
			 horRep.save(h);
		}
		 return h;
	}
	
	public Horaire removeThisSchedule(Horaire h) {
		h.setStatusHoraire(false);
		
		return horRep.save(h);
	}
	
	public Horaire modifThisSchedule(Horaire h) throws Exception {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			int id = ((JwtUserDetails)principal).getId();
			int idForFind = h.getIdHoraire();
			Optional<Employee> modifByUserLog =empRep.findById(id);
			Horaire horInDb = horRep.findScheduleById(idForFind);
			h.setEmployeeFromHoraire(horInDb.getEmployeeFromHoraire());
			h.setCreateBy(horInDb.getCreateBy());
			h.setModifBy(modifByUserLog.get());
			return horRep.save(h);
		
		
	}
}

