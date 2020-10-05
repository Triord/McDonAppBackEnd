package com.projet.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projet.repositories.EmployeeRepo;
import com.projet.beans.Employee;

@Service
public class EmployeeImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empR;
	
	public Set<Employee> findAll(){
		Set<Employee> emp = new HashSet<Employee>((Collection<Employee>) empR.findAll()); 
		return emp;
		}
	public Employee addEmp(Employee emp) {
		emp.setStatut(true);
		return empR.save(emp);
		
	}
}
