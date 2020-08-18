package com.projet.beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "horaire_")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idHoraire")
public class Horaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idHoraire", nullable=false)
	int idHoraire ;
	
	@Column(name="dateJour")
	Date dateJour;
	
	@Column(name="heureDebut")
	float heureDebut;
	
	@Column(name="heureFin")
	float heureFin;
	
	@Column(name="heureDebut2")
	float heureDebut2;
	
	@Column(name="heureFin2")
	float heureFin2;
	
	@OneToMany(mappedBy = "horaire",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<RaisonModif> rm;
	
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idEmploye",nullable = false)
	private Employee employee;

	public int getIdHoraire() {
		return idHoraire;
	}

	public void setIdHoraire(int idHoraire) {
		this.idHoraire = idHoraire;
	}

	public Date getDateJour() {
		return dateJour;
	}

	public void setDateJour(Date dateJour) {
		this.dateJour = dateJour;
	}

	public float getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(float heureDebut) {
		this.heureDebut = heureDebut;
	}

	public float getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(float heureFin) {
		this.heureFin = heureFin;
	}

	public float getHeureDebut2() {
		return heureDebut2;
	}

	public void setHeureDebut2(float heureDebut2) {
		this.heureDebut2 = heureDebut2;
	}

	public float getHeureFin2() {
		return heureFin2;
	}

	public void setHeureFin2(float heureFin2) {
		this.heureFin2 = heureFin2;
	}

	public Set<RaisonModif> getRm() {
		return rm;
	}

	public void setRm(Set<RaisonModif> rm) {
		this.rm = rm;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
