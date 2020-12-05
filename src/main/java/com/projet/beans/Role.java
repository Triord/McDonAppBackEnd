package com.projet.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "role_")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idRole",
		resolver = EntityIdResolver.class)
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idRole", nullable=false)
	int idRole ;

	@Column(name="nomRole")
	String nomRole;
	
	@ManyToMany(mappedBy = "role",fetch = FetchType.LAZY)
	private Set<Employee> employeeFromRole = new HashSet<>();
	

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = 1;
	}

	public String getNomRole() {
		return nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	public Set<Employee> getEmployeeFromRole() {
		return employeeFromRole;
	}

	public void setEmployeeFromRole(Set<Employee> employeeFromRole) {
		this.employeeFromRole = employeeFromRole;
	}

	
	
	
	
}
