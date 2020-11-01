package com.projet.beans;

import java.sql.Time;
import java.util.Date;
import java.util.Set;
import comp.projet.deserializer.*;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
	Time heureDebut;
	
	@Column(name="heureFin")
	Time heureFin;
	
	
	@Column(name="heureDebut2")
	Time heureDebut2;
	
	
	@Column(name="heureFin2")
	Time heureFin2;
	
	@Column(name="statusHoraire")
	Boolean statusHoraire;
	
	@OneToMany(mappedBy = "horaire",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<RaisonModif> rm;
	
	@ManyToOne(cascade = { CascadeType.MERGE})
	@JoinColumn(name = "idEmploye" , nullable = false)
	private Employee employee;
	
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idUserCreate", nullable = false)
	private Employee createBy;
	
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idUserModif", nullable = false)
	private Employee modifBy;
	

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

	

	public Time getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Time heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Time getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Time heureFin) {
		this.heureFin = heureFin;
	}

	public Time getHeureDebut2() {
		return heureDebut2;
	}

	public void setHeureDebut2(Time heureDebut2) {
		this.heureDebut2 = heureDebut2;
	}

	public Time getHeureFin2() {
		return heureFin2;
	}

	public void setHeureFin2(Time heureFin2) {
		this.heureFin2 = heureFin2;
	}
	public Employee getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Employee createBy) {
		this.createBy = createBy;
	}
	//y avais un jsonIgnore qui evitais une erreur ici
	public Employee getModifBy() {
		return modifBy;
	}

	public void setModifBy(Employee modifBy) {
		this.modifBy = modifBy;
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

	public Boolean getStatusHoraire() {
		return statusHoraire;
	}

	public void setStatusHoraire(Boolean statusHoraire) {
		this.statusHoraire = statusHoraire;
	}
	
	

}
