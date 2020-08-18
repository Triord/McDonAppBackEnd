package com.projet.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.beans.Disponibilite;
import com.projet.repositories.DisponibiliteRepo;

@Service
public class DisponibiliteImpl implements DisponibiliteService {
	@Autowired
	private DisponibiliteRepo dispRep;
	
	public Set<Disponibilite> allDisp(){
		Set<Disponibilite> disp =  new HashSet<Disponibilite>((Collection<Disponibilite>) dispRep.findAllOrderBy());
		return disp;
	}
	public Disponibilite upDisp(Disponibilite disp, int id) {
		id = disp.getIdDispo();
		Disponibilite d =  dispRep.findById(id).get();
		d.setIdDispo(id);
		d.setLundi(d.getLundi());
		d.setLundi2(d.getLundi2());
		d.setMardi(d.getMardi());
		d.setMardi2(d.getMardi2());
		d.setMercredi(d.getMercredi());
		d.setMercredi2(d.getMercredi2());
		d.setJeudi(d.getJeudi());
		d.setJeudi2(d.getJeudi2());
		d.setVendredi(d.getVendredi());
		d.setVendredi2(d.getVendredi2());
		d.setSamedi(d.getSamedi());
		d.setSamedi2(d.getSamedi2());
		d.setDimanche(d.getDimanche());
		d.setDimanche2(d.getDimanche2());
		d.setEmployee(d.getEmployee());
		dispRep.save(d);
		return d;
	}
}
