package com.projet.beans;

import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "disponibilite_")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idDispo")
public class Disponibilite implements Comparable<Disponibilite> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDispo", nullable=false)
	int idDispo ;
	
	@Column(name="lundi")
	Time lundi;
	
	@Column(name="lundi2")
	Time lundi2;
	
	@Column(name="mardi")
	Time mardi;
	
	@Column(name="mardi2")
	Time mardi2;
	
	@Column(name="mercredi")
	Time mercredi;
	
	@Column(name="mercredi2")
	Time mercredi2;
	
	@Column(name="jeudi")
	Time jeudi;
	
	@Column(name="jeudi2")
	Time jeudi2;
	
	@Column(name="vendredi")
	Time vendredi;
	
	@Column(name="vendredi2")
	Time vendredi2;
	
	@Column(name="samedi")
	Time samedi;
	
	@Column(name="samedi2")
	Time samedi2;
	
	@Column(name="dimanche")
	Time dimanche;
	
	@Column(name="dimanche2")
	Time dimanche2;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idEmploye")
	private Employee employee;
	
	
	public int getIdDispo() {
		return idDispo;
	}

	public void setIdDispo(int idDispo) {
		this.idDispo = idDispo;
	}

	
	public Employee getEmployee() {
		
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int compareTo(Disponibilite o) {
		// TODO Auto-generated method stub
		
		return this.getEmployee().getNom().compareTo(o.getEmployee().getNom());
		
	}

	public Time getLundi() {
		return lundi;
	}

	public void setLundi(Time lundi) {
		this.lundi = lundi;
	}

	public Time getLundi2() {
		return lundi2;
	}

	public void setLundi2(Time lundi2) {
		this.lundi2 = lundi2;
	}

	public Time getMardi() {
		return mardi;
	}

	public void setMardi(Time mardi) {
		this.mardi = mardi;
	}

	public Time getMardi2() {
		return mardi2;
	}

	public void setMardi2(Time mardi2) {
		this.mardi2 = mardi2;
	}

	public Time getMercredi() {
		return mercredi;
	}

	public void setMercredi(Time mercredi) {
		this.mercredi = mercredi;
	}

	public Time getMercredi2() {
		return mercredi2;
	}

	public void setMercredi2(Time mercredi2) {
		this.mercredi2 = mercredi2;
	}

	public Time getJeudi() {
		return jeudi;
	}

	public void setJeudi(Time jeudi) {
		this.jeudi = jeudi;
	}

	public Time getJeudi2() {
		return jeudi2;
	}

	public void setJeudi2(Time jeudi2) {
		this.jeudi2 = jeudi2;
	}

	public Time getVendredi() {
		return vendredi;
	}

	public void setVendredi(Time vendredi) {
		this.vendredi = vendredi;
	}

	public Time getVendredi2() {
		return vendredi2;
	}

	public void setVendredi2(Time vendredi2) {
		this.vendredi2 = vendredi2;
	}

	public Time getSamedi() {
		return samedi;
	}

	public void setSamedi(Time samedi) {
		this.samedi = samedi;
	}

	public Time getSamedi2() {
		return samedi2;
	}

	public void setSamedi2(Time samedi2) {
		this.samedi2 = samedi2;
	}

	public Time getDimanche() {
		return dimanche;
	}

	public void setDimanche(Time dimanche) {
		this.dimanche = dimanche;
	}

	public Time getDimanche2() {
		return dimanche2;
	}

	public void setDimanche2(Time dimanche2) {
		this.dimanche2 = dimanche2;
	}
	
	
	

}
