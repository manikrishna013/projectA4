package com.developers.projectA4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developers.projectA4.Exception.DuplicateException;
import com.developers.projectA4.Model.Country;
import com.developers.projectA4.Repository.CountryRepository;

@Service
public class CountryService {
	
	private final CountryRepository countryRepository;
	
	@Autowired
	CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	public Country createCountries(Country country) {
		
		Country duplicateCode = countryRepository.findByCountryCode(country.getCountryCode());
		if(duplicateCode != null){
			throw new DuplicateException("Country Code");
		}
		Country data = countryRepository.insert(country);
		return data;
		
	}

	public List<Country> getAllCountries() {
		List<Country> listAll = countryRepository.findAll();
		
		return listAll;
		
	}

	public Country updateCountry(String id, Country country) {
		
		Country data = countryRepository.findAllById(id);
		if(data != null){
			data.setCountryCode(country.getCountryCode());
			data.setCountryName(country.getCountryName());
			countryRepository.save(data);
		}
		return data;
	}

	public Country deleteCountry(String id) {
		Country details= countryRepository.findAllById(id);
		countryRepository.deleteById(id);
		return details;
		
	}
}
