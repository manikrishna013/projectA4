package com.developers.projectA4.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.developers.projectA4.Model.Genres;

public interface GenresRepository  extends MongoRepository<Genres, String>{

	

	Genres findByGenreName(String genreName);

	
	

}
