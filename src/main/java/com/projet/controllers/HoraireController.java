package com.projet.controllers;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Disponibilite;
import com.projet.beans.Horaire;
import com.projet.repositories.HoraireRepo;
import com.projet.services.HoraireImpl;

@RestController
public class HoraireController {

	@Autowired
	private HoraireImpl horS;
	@Autowired
	private HoraireRepo horR;
	
	
	@GetMapping("/horaire")
	public Set<Horaire> allHoraire(Model model) {
		return horS.findAll();
	}
	
	@GetMapping("/horaireWent")
    public List<Horaire> getHoraireBtwnDate(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateIn, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date dateOut) throws ParseException {
		
	    
        return horR.findHoraireBtwn(dateIn, dateOut);
        
    }
	@PostMapping("/createSchedule")
	public Horaire addSchedule(@RequestBody Horaire h) throws Exception {
		return horS.createScheduleDayperDay(h);
	}
	@GetMapping("/horaireById/{id}")
	public Optional<Horaire> getDispo(@PathVariable int id,Model model) {
		return horR.findById(id);		
	}
	
}
