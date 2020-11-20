package com.projet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Conge;
import com.projet.repositories.CongeRepo;
import com.projet.services.CongeImpl;

@RestController
public class CongeController {

	@Autowired
	private CongeImpl congeS;
	@Autowired
	private CongeRepo congeR;
	
	@GetMapping("/allConge")
	public List<Conge> allConge(){
		return congeS.findAll();
	}
	@GetMapping("/oneConge/{id}")
	public Conge oneConge(@PathVariable int id){
		return congeR.findById(id).get();
	}
	
	@CrossOrigin(origins = "http://127.0.0.1/:4200")
	@PutMapping("/acceptConge")
	public Conge acceptConge(@RequestBody Conge con) {
		return congeS.acceptConge(con);
	}
	
	@CrossOrigin(origins = "http://127.0.0.1/:4200")
	@PutMapping("/unacceptConge")
	public Conge unacceptConge(@RequestBody Conge con) {
		return congeS.unacceptConge(con);
	}
	
	
}
