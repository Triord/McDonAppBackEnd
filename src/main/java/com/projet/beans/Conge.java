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
@Table(name = "conge_")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idConge")
public class Conge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idConge", nullable=false)
	int idConge ;
	
	@Column(name="dateConge")
	Date dateConge;
	
	@Column(name="raison")
	String raison;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idEmploye",nullable = false)
	private Employee employee;
	
	public int getIdConge() {
		return idConge;
	}

	public void setIdConge(int idConge) {
		this.idConge = idConge;
	}

	public Date getDateConge() {
		return dateConge;
	}

	public void setDateConge(Date dateConge) {
		this.dateConge = dateConge;
	}

	public String getRaison() {
		return raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
