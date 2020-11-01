package com.projet.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet.beans.Disponibilite;
import com.projet.beans.Employee;


@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	@Query(value ="select idDispo from disponibilite_  where idEmploye = :id", nativeQuery =true)
	String findDispo(int id);
	Optional<Employee> findByEmail(String email);
	
	@Query(value="select * from employe_ where idEmploye =:id",nativeQuery=true)
	Employee employeOfSchedule(String id);
	
	@Query(value="select * from employe_ order by nom",nativeQuery=true)
	Set <Employee> findAllByOrder();
}
