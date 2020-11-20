package com.projet.beans;

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
@Table(name = "question_")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idQuestion",
		resolver = EntityIdResolver.class)
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idQuestion", nullable=false)
	int idQuestion ;
	
	@Column(name="corps")
	String corps;
	
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idEmploye",nullable = false)
	private Employee employeeFromQuestion;

	@OneToMany(mappedBy = "question",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Reponse> reponse;
	
	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}

	public Employee getEmployeeFromQuestion() {
		return employeeFromQuestion;
	}

	public void setEmployeeFromQuestion(Employee employeeFromQuestion) {
		this.employeeFromQuestion = employeeFromQuestion;
	}

	public Set<Reponse> getReponse() {
		return reponse;
	}

	public void setReponse(Set<Reponse> reponse) {
		this.reponse = reponse;
	}
	
	
	
}
