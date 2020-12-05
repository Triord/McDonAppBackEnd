package com.projet.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.projet.beans.Employee;
import com.projet.beans.Forum;
import com.projet.jwt.JwtUserDetails;
import com.projet.repositories.EmployeeRepo;
import com.projet.repositories.ForumRepo;

@Service
public class ForumImpl {

	@Autowired
	private ForumRepo forumR;
	@Autowired
	private EmployeeRepo empR;
	
	public Forum addNews(Forum forum){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int id = ((JwtUserDetails)principal).getId();
		Employee emp = empR.findById(id).get();
		Date date = new Date();
		
		forum.setDatePublication(date);
		forum.setEmployeeFromForum(emp);
		forumR.save(forum);
		return forum;
	}
}
