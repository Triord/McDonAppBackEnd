package com.projet.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.ViewEmploye;
import com.projet.repositories.ViewEmplRepo;
import com.projet.services.ViewEmplImpl;

@RestController
public class ViewEmplController {

	@Autowired
	private ViewEmplRepo veRep;
	@Autowired
	private ViewEmplImpl veServ;
	
	
	@GetMapping("/allVisioDone")
	public Set<ViewEmploye> getAllEmpViewed(){
		return veRep.allEmpViewed();
	}
	@GetMapping("/allVisioDone/{id}")
	public ViewEmploye getEmpViewedByid(@PathVariable int id){
		return veRep.findById(id).get();
	}
	@PostMapping("/saveRaisonView")
	public ViewEmploye methodtest(@RequestBody ViewEmploye ve) {
		return veServ.saveRaisonView(ve);
	}
	
}
