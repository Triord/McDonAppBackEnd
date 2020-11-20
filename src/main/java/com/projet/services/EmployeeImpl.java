package com.projet.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.projet.repositories.EmployeeRepo;
import com.projet.beans.Employee;
import com.projet.jwt.JwtUserDetails;

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
	public Employee changeStatusOnDispo(Employee emp){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int id = ((JwtUserDetails)principal).getId();
		emp = empR.findById(id).get();
		emp.setStatut(true);
		return empR.save(emp);
	}
	public Employee changeStatusOnIndispo(Employee emp){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int id = ((JwtUserDetails)principal).getId();
		emp = empR.findById(id).get();
		emp.setStatut(false);
		return empR.save(emp);
	}
	public Employee changePassword(Employee emp){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int id = ((JwtUserDetails)principal).getId();
		emp = empR.findById(id).get();
		emp.setMdp(emp.getMdp());
		return empR.save(emp);
	}
	public Employee changeNbrHeure(Employee emp) {
		
		int id = emp.getIdEmploye();
		Employee empInDb = empR.findById(id).get();
		empInDb.setNbrHeure(emp.getNbrHeure());
		return empR.save(empInDb);
	}
	
}
