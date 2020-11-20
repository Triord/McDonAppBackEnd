package com.projet.repositories;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.beans.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer>{
	@Transactional
	@Modifying
	@Query(value="update userRole set idRole=1 where idEmploye = :idEmploye", nativeQuery = true)
	public void beAChief(@Param("idEmploye")String idEmp);
	
	@Transactional
	@Modifying
	@Query(value="update userRole set idRole=2 where idEmploye = :idEmploye", nativeQuery = true)
	public void beAManager(@Param("idEmploye")String idEmp);
	
	@Transactional
	@Modifying
	@Query(value="update userRole set idRole=3 where idEmploye = :idEmploye", nativeQuery = true)
	public void beAWorker(@Param("idEmploye")String idEmp);
	
	@Transactional
	@Modifying
	@Query(value="update userRole set idRole=4 where idEmploye = :idEmploye", nativeQuery = true)
	public void beAStudent(@Param("idEmploye")String idEmp);
	
	@Query(value="select e.idEmploye ,e.nom , e.prenom, r.nomRole  from employe_ e join userRole u on e.idEmploye = u.idEmploye join role_ r on u.idRole = r.idRole where u.idEmploye = :idEmp", nativeQuery = true)
	public Object allinfo(@Param("idEmp")String idEmp);
}
