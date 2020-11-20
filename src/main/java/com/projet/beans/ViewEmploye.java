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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "viewEmploye_")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idViewEmp",
		resolver = EntityIdResolver.class)
public class ViewEmploye {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idViewEmp", nullable=false)
	int idViewEmp ;
	
	@Column(name="raisonView", nullable= false)
	String raisonView;
	
	@Column(name="dateView", nullable = false)
	Date dateView;
	
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idEmpView")
	private Employee employeView;
	
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "idMannaWhoViewed")
	private Employee manaWhoViewed;

	public int getIdViewEmp() {
		return idViewEmp;
	}

	public void setIdViewEmp(int idViewEmp) {
		this.idViewEmp = idViewEmp;
	}

	public String getRaisonView() {
		return raisonView;
	}

	public void setRaisonView(String raisonView) {
		this.raisonView = raisonView;
	}

	public Date getDateView() {
		return dateView;
	}

	public void setDateView(Date dateView) {
		this.dateView = dateView;
	}
	
	
	public Employee getEmployeView() {
		return employeView;
	}

	public void setEmployeView(Employee employeView) {
		this.employeView = employeView;
	}

	public Employee getManaWhoViewed() {
		return manaWhoViewed;
	}

	public void setManaWhoViewed(Employee manaWhoViewed) {
		this.manaWhoViewed = manaWhoViewed;
	}
	
	
}
