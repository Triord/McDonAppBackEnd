package com.projet.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet.beans.ViewEmploye;

@Repository
public interface ViewEmplRepo extends CrudRepository<ViewEmploye, Integer>{

	@Query(value="select* from viewEmploye_", nativeQuery = true)
	Set<ViewEmploye> allEmpViewed();
}
