package com.projet.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet.beans.Forum;

@Repository
public interface ForumRepo  extends CrudRepository<Forum, Integer>{

	
}
