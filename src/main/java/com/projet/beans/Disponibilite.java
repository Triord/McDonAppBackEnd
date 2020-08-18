package com.projet.beans;

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
import com.sun.istack.NotNull;

@Entity
@Table(name = "disponibilite_")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idDispo")
public class Disponibilite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idDispo", nullable=false)
	int idDispo ;
	
	@Column(name="lundi")
	String lundi;
	
	@Column(name="lundi2")
	String lundi2;
	
	@Column(name="mardi")
	String mardi;
	
	@Column(name="mardi2")
	String mardi2;
	
	@Column(name="mercredi")
	String mercredi;
	
	@Column(name="mercredi2")
	String mercredi2;
	
	@Column(name="jeudi")
	String jeudi;
	
	@Column(name="jeudi2")
	String jeudi2;
	
	@Column(name="vendredi")
	String vendredi;
	
	@Column(name="vendredi2")
	String vendredi2;
	
	@Column(name="samedi")
	String samedi;
	
	@Column(name="samedi2")
	String samedi2;
	
	@Column(name="dimanche")
	String dimanche;
	
	@Column(name="dimanche2")
	String dimanche2;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idEmploye")
	private Employee employee;
	
	
	public int getIdDispo() {
		return idDispo;
	}

	public void setIdDispo(int idDispo) {
		this.idDispo = idDispo;
	}

	public String getLundi() {
		return lundi;
	}

	public void setLundi(String lundi) {
		this.lundi = lundi;
	}

	public String getLundi2() {
		return lundi2;
	}

	public void setLundi2(String lundi2) {
		this.lundi2 = lundi2;
	}

	public String getMardi() {
		return mardi;
	}

	public void setMardi(String mardi) {
		this.mardi = mardi;
	}

	public String getMardi2() {
		return mardi2;
	}

	public void setMardi2(String mardi2) {
		this.mardi2 = mardi2;
	}

	public String getMercredi() {
		return mercredi;
	}

	public void setMercredi(String mercredi) {
		this.mercredi = mercredi;
	}

	public String getMercredi2() {
		return mercredi2;
	}

	public void setMercredi2(String mercredi2) {
		this.mercredi2 = mercredi2;
	}

	public String getJeudi() {
		return jeudi;
	}

	public void setJeudi(String jeudi) {
		this.jeudi = jeudi;
	}

	public String getJeudi2() {
		return jeudi2;
	}

	public void setJeudi2(String jeudi2) {
		this.jeudi2 = jeudi2;
	}

	public String getVendredi() {
		return vendredi;
	}

	public void setVendredi(String vendredi) {
		this.vendredi = vendredi;
	}

	public String getVendredi2() {
		return vendredi2;
	}

	public void setVendredi2(String vendredi2) {
		this.vendredi2 = vendredi2;
	}

	public String getSamedi() {
		return samedi;
	}

	public void setSamedi(String samedi) {
		this.samedi = samedi;
	}

	public String getSamedi2() {
		return samedi2;
	}

	public void setSamedi2(String samedi2) {
		this.samedi2 = samedi2;
	}

	public String getDimanche() {
		return dimanche;
	}

	public void setDimanche(String dimanche) {
		this.dimanche = dimanche;
	}

	public String getDimanche2() {
		return dimanche2;
	}

	public void setDimanche2(String dimanche2) {
		this.dimanche2 = dimanche2;
	}
	
	public Employee getEmployee() {
		
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	

}
