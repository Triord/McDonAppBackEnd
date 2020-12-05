package com.projet.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "forum_")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idForum",
		resolver = EntityIdResolver.class)
public class Forum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idForum", nullable=false)
	int idForum ;
	
	@Column(name="titre")
	String titre;
	
	@Column(name="contenu")
	String contenu;
	
	@Column(name="datePublication")
	Date datePublication;
	
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEmploye")
    private Employee employeeFromForum;
	
	public int getIdForum() {
		return idForum;
	}

	public void setIdForum(int idForum) {
		this.idForum = idForum;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public Employee getEmployeeFromForum() {
		return employeeFromForum;
	}

	public void setEmployeeFromForum(Employee employeeFromForum) {
		this.employeeFromForum = employeeFromForum;
	}

	
	
	
}
