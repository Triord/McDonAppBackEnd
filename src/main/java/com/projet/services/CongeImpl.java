package com.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.beans.Conge;
import com.projet.repositories.CongeRepo;

@Service
public class CongeImpl {

	@Autowired
	private CongeRepo congeR;
	
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
	
}
