package com.projet.beans;

import java.util.Date;

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
@Table(name = "raisonModif_")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idRM")
public class RaisonModif {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idRM", nullable=false)
	int idRM ;
	
	@Column(name="raison")
	String raison;
	
	@Column(name="dateModif")
	Date dateModif;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "idEmpModif")
	private Employee employe;
	
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idHoraire",nullable = false)
	private Horaire horaire;

	public int getIdRM() {
		return idRM;
	}

	public void setIdRM(int idRM) {
		this.idRM = idRM;
	}

	public String getRaison() {
		return raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}

	public Date getDateModif() {
		return dateModif;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	public Horaire getHoraire() {
		return horaire;
	}

	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}

	public Employee getEmploye() {
		return employe;
	}

	public void setEmploye(Employee employe) {
		this.employe = employe;
	}
	
	
	
	

}
