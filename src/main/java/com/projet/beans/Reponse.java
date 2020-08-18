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

@Entity
@Table(name = "reponse_")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idReponse")
public class Reponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idReponse", nullable=false)
	int idReponse ;
	
	@Column(name="corpsReponse")
	String corpsReponse;
	
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idQuestion",nullable = false)
	private Question question;
	
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idEmploye",nullable = false)
	private Employee employee;

	public int getIdReponse() {
		return idReponse;
	}

	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}

	public String getCorpsReponse() {
		return corpsReponse;
	}

	public void setCorpsReponse(String corpsReponse) {
		this.corpsReponse = corpsReponse;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
}
