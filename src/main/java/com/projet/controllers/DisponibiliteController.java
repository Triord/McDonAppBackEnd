package com.projet.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Disponibilite;
import com.projet.repositories.DisponibiliteRepo;
import com.projet.services.DisponibiliteImpl;

@RestController
public class DisponibiliteController {

	@Autowired
	private DisponibiliteImpl dispImpl;
	@Autowired
	private DisponibiliteRepo dispRep;
	
	@GetMapping("/disponibilite")
	public Set<Disponibilite> allDispo() {
		return dispImpl.allDisp();
	}
	
	@PutMapping("/disponibilite/{id}")
	public Disponibilite upDisp(@RequestBody Disponibilite disp ,@PathVariable int id) {	
		return dispRep.save(disp);
	}
	@PostMapping("/disponibilite")
	public Disponibilite addDisp(@RequestBody Disponibilite disp ) {	
		return dispRep.save(disp);
	}
	
}
