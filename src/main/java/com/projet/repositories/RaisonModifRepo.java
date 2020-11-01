package com.projet.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet.beans.Employee;
import com.projet.beans.RaisonModif;

@Repository
public interface RaisonModifRepo extends CrudRepository<RaisonModif, Integer> {

	@Query(value="select * from raisonModif_ ",nativeQuery=true)
	Set <RaisonModif> findAllModif();
	
}
