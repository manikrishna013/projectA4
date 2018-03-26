package com.developers.projectA4.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developers.projectA4.Exception.DuplicateException;
import com.developers.projectA4.Model.Genres;
import com.developers.projectA4.Repository.GenresRepository;

@Service
public class GenresService {

	private final GenresRepository genresRepository;
	
	@Autowired
	GenresService(GenresRepository genresRepository){
		this.genresRepository = genresRepository;
	}
	
	public Genres createGenres(Genres genres) {
		
		 Genres details = genresRepository.findByGenreName(genres.getGenreName());
		 
		if(details != null){
			throw new DuplicateException(genres.getGenreName());
		}
		else{
			genresRepository.save(genres);
			return genres;
		}
		
	}

	public List<Genres> getAllGenres() {
		
		List<Genres> details =genresRepository.findAll();
		
		return details;
		
	}
}

