package com.developers.projectA4.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.developers.projectA4.Exception.DuplicateException;
import com.developers.projectA4.Exception.UnrecognizedPropException;
import com.developers.projectA4.Model.Country;
import com.developers.projectA4.Model.Response;
import com.developers.projectA4.Service.CountryService;

@CrossOrigin
@RestController
@RequestMapping("/api.v1")
public class CountryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	private final CountryService countryService;
	
	@Autowired
	CountryController(CountryService countryService) {
		this.countryService = countryService;
		}
	
	@RequestMapping(value="/country", method= RequestMethod.POST)
	public @ResponseBody Country insertCountries(@RequestBody Country country){
		Country data = null;
		
		if(country != null){
			data = countryService.createCountries(country);
		}
		return data;
	}
	
	@RequestMapping(value="/country",method = RequestMethod.GET)
	public @ResponseBody List<Country> getAll(){
			
		List<Country> list = countryService.getAllCountries();
		
		return list;
	}
	
	@RequestMapping(value ="/country/{id}" ,method = RequestMethod.PUT)
	public @ResponseBody Country updateCountry(@PathVariable("id") String id,
			@RequestBody Country country){
		Country data = null;
		if(id != null){
			
			data = countryService.updateCountry(id,country);
		}
		
		return data;
		
	}
	
	@RequestMapping(value="/country/{id}",method = RequestMethod.DELETE)
	public @ResponseBody String deleteCountry(@PathVariable("id") String id){
		
		Country data = countryService.deleteCountry(id);
		
		return "Deleted " + data.getCountryName();
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public Response<String> handleCategoryDuplicate(DuplicateException ex) {
		LOGGER.error("Handling error with message: {}", ex.getMessage());
		Response<String> res = new Response<>();
		res.setMessage(ex.getMessage());
		return res;
	}
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response<String> handleUnrecognizedProp(UnrecognizedPropException ex) {
		LOGGER.error("Handling error with message: {}", ex.getMessage());
		Response<String> res = new Response<>();
		res.setMessage(ex.getMessage());
		return res;
	}

}
