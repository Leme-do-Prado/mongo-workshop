package com.lemedoprado.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemedoprado.workshopmongo.domain.Post;
import com.lemedoprado.workshopmongo.repositories.PostRepository;
import com.lemedoprado.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Post user = repo.findOne(id);
		if(user==null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
}
