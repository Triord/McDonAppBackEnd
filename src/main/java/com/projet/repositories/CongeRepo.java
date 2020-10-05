package com.projet.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.beans.Conge;

@Repository
public interface CongeRepo extends CrudRepository<Conge, Integer> {

	@Query(value="select* from conge_ as c join horaire_ as h on c.idEmploye = :h.idEmploye where c.dateConge = :h.dateJour", nativeQuery = true)
	public Conge findConge(@Param("h.idEmploye") int idEmp,@Param("h.dateJour") String dtHoraire);
}
