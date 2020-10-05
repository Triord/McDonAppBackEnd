package com.projet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet.beans.Disponibilite;


@Repository
public interface DisponibiliteRepo extends CrudRepository<Disponibilite, Integer> {
	@Query(value="select* from disponibilite_  order by lundi,mardi,mercredi,jeudi,vendredi, samedi, dimanche", nativeQuery = true)
	List <Disponibilite> findAllOrderBy();
	public List<Disponibilite> findAllByOrderByLundiAsc();
	//@Query(value ="select nom,prenom from disponibilite_ d join employe_ e on d.idEmploye=e.idEmploye where d. = :id", nativeQuery =true)
	//List <Disponibilite> findLocByIdUser(int id);
	
	@Query(value="select * from disponibilite_ as d join employe_ as e on d.idEmploye = :idUC", nativeQuery = true)
	Disponibilite findDispInHorCreate(int idUC);

}
