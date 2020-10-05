package com.projet.repositories;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.beans.Horaire;



@Repository
public interface HoraireRepo extends CrudRepository<Horaire, Integer> {
	
	
	@Query(value ="select * from horaire_ where dateJour between :dateIn and :dateOut", nativeQuery =true)
	List <Horaire> findHoraireBtwn(@Param("dateIn") Date dateIn ,@Param("dateOut")Date dateOut);
	
	
	//
	//;
}

