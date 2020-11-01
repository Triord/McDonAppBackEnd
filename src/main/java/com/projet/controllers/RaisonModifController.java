package com.projet.controllers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Horaire;
import com.projet.beans.RaisonModif;
import com.projet.repositories.RaisonModifRepo;
import com.projet.services.RaisonModifImpl;

@RestController
public class RaisonModifController {

	@Autowired
	private RaisonModifRepo rmRep;
	@Autowired
	private RaisonModifImpl rmServ;
	
	@PostMapping("/saveModif")
	public RaisonModif rmSave(@RequestBody RaisonModif rm){
		return rmServ.saveModif(rm);
	}
	@GetMapping("/getModifDone")
	public Set<RaisonModif> rmGet(){
		return rmRep.findAllModif();
	}
	@GetMapping("/getModifById/{id}")
	public Optional<RaisonModif> rmGetById(@PathVariable int id){
		return rmRep.findById(id);
	}
}
