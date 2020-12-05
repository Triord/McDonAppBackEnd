package com.projet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.beans.Forum;
import com.projet.repositories.ForumRepo;
import com.projet.services.ForumImpl;

@RestController
public class ForumController {

	@Autowired
	private ForumRepo forumR;
	@Autowired
	private ForumImpl forumS;
	
	@GetMapping("/getForumNews")
	public List<Forum> allForumNews(){
		List<Forum> forum = (List<Forum>) forumR.findAll();
		return forum;
		}
	@PostMapping("/addForumNews")
	public Forum addForumNews(@RequestBody Forum forum) {
		return forumS.addNews(forum);
	}
	@GetMapping("/oneNews/{id}")
	public Forum oneNews(@PathVariable int id){
		return forumR.findById(id).get();
	}
	
	
}
