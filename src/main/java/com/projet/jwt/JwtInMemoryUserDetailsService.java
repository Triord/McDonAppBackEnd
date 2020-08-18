package com.projet.jwt;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projet.beans.Employee;
import com.projet.repositories.EmployeeRepo;







@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  @Autowired
  private EmployeeRepo empRepo;
	
	
  //static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  //static {
  //  inMemoryUserList.add(new JwtUserDetails(1L, "toto",
  //      "$2a$10$Bi7DWJTLZp4fjT8oT96q0erNCzQD5QtR62uT1v7QFWddmp3c9.g.G", "ADMIN"));
  //}

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	  
	  System.out.println("email");
	  Optional<Employee> user = empRepo.findByEmail(email);
	  Optional<JwtUserDetails> userDetails = Optional.empty();
	  
	  
	  
	  
	  if(user.isPresent()) {
		  userDetails = Optional.of(new JwtUserDetails(user.get().getIdEmploye(),user.get().getEmail(),user.get().getMdp(),user.get().getRole())); 
	  }
	  
	  //Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
      //  .filter(user -> user.getUsername().equals(username)).findFirst();

	  if (!userDetails.isPresent()) {
		  throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", email));
	  }

	  return userDetails.get();
  }
  

}