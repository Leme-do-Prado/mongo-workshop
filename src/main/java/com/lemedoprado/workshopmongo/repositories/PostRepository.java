package com.lemedoprado.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lemedoprado.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

	@Query("{ 'title': { $regex: ?0, /pattern, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
}
