package com.projet.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.projet.services.Password;

@Entity
@Table(name = "employe_")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idEmploye", nullable=false)
	int idEmploye ;
	
	@Column(name="nom")
	String nom;
	
	@Column(name="prenom")
	String prenom;
	
	@Column(name="email")
	String email;
	
	@Column(name="mdp")
	String mdp;
	
	@Column(name="ddn")
	Date ddn;
	
	@Column(name="nbrHeure")
	float nbrHeure;
	
	@Column(name="statut")
	boolean statut;
	
	@ManyToMany(cascade = { CascadeType.MERGE },fetch = FetchType.EAGER)
    @JoinTable(
	        name = "userRole", 
	        joinColumns = { @JoinColumn(name = "idEmploye") }, 
	        inverseJoinColumns = { @JoinColumn(name = "idRole") }
	    )
	private Set<Role> role = new HashSet<>();
	
	@OneToOne(mappedBy = "employee", fetch = FetchType.LAZY)
    private Forum forum;
	
	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	public Set<RaisonModif> raisonModif;
	
	@OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Question> question;
	
	@OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Disponibilite> dispo;
	
	@OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Reponse> reponse;
	
	@OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Conge> conge;
	
	@OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Horaire> horaire;
	
	@OneToMany(mappedBy = "employeView",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<ViewEmploye> viewEmploye;
	
	@OneToMany(mappedBy = "manaWhoViewed",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<ViewEmploye> whoViewedMana;
	
	@OneToMany(mappedBy = "createBy",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Horaire> horaireCreer;
	
	@OneToMany(mappedBy = "modifBy",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	public Set<Horaire> horaireModif;

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		Password p = new Password(mdp);
		p.firstHash();
		this.mdp = p.getHash();
	}

	public Date getDdn() {
		return ddn;
	}

	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}

	public float getNbrHeure() {
		return nbrHeure;
	}

	public void setNbrHeure(float nbrHeure) {
		this.nbrHeure = nbrHeure;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}
	
	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}
	public Set<Disponibilite> getDispo() {
		return dispo;
	}

	public void setDispo(Set<Disponibilite> dispo) {
		this.dispo = dispo;
	}

	public Set<Reponse> getReponse() {
		return reponse;
	}

	public void setReponse(Set<Reponse> reponse) {
		this.reponse = reponse;
	}
	@JsonIgnore
	public Set<Conge> getConge() {
		return conge;
	}

	public void setConge(Set<Conge> conge) {
		this.conge = conge;
	}
	public Set<Horaire> getHoraire() {
		return horaire;
	}

	public void setHoraire(Set<Horaire> horaire) {
		this.horaire = horaire;
	}
	@JsonIgnore
	public Set<Horaire> getHoraireCreer() {
		return horaireCreer;
	}

	public void setHoraireCreer(Set<Horaire> horaireCreer) {
		this.horaireCreer = horaireCreer;
	}
	@JsonIgnore
	public Set<Horaire> getHoraireModif() {
		return horaireModif;
	}

	public void setHoraireModif(Set<Horaire> horaireModif) {
		this.horaireModif = horaireModif;
	}
	@JsonIgnore
	public Set<RaisonModif> getRaisonModif() {
		return raisonModif;
	}

	public void setRaisonModif(Set<RaisonModif> raisonModif) {
		this.raisonModif = raisonModif;
	}

	public Set<ViewEmploye> getViewEmploye() {
		return viewEmploye;
	}

	public void setViewEmploye(Set<ViewEmploye> viewEmploye) {
		this.viewEmploye = viewEmploye;
	}

	public Set<ViewEmploye> getWhoViewedMana() {
		return whoViewedMana;
	}

	public void setWhoViewedMana(Set<ViewEmploye> whoViewedMana) {
		this.whoViewedMana = whoViewedMana;
	}
	
	
}
