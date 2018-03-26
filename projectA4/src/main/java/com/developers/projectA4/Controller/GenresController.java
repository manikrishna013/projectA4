package com.developers.projectA4.Controller;




import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.developers.projectA4.Model.Genres;
import com.developers.projectA4.Service.GenresService;

@RestController
@RequestMapping("/api.v1/genres")
public class GenresController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GenresController.class);
	
	private final GenresService genresService;
	
	@Autowired
	GenresController(GenresService genresService) {
		this.genresService = genresService;
				
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Genres createGenres(@RequestBody Genres genres){
		
		Genres dto = genresService.createGenres(genres);
		
		return dto;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Genres> getAllGenres(){
		
		List<Genres> details = genresService.getAllGenres();
		
		return details;
		
	}
	

}
