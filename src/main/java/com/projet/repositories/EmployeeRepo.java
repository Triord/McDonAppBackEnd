package com.projet.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet.beans.Employee;


@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	
	Optional<Employee> findByEmail(String email);
	
}
