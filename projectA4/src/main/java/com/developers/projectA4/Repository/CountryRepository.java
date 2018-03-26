package com.developers.projectA4.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.developers.projectA4.Model.Country;


public interface CountryRepository extends MongoRepository<Country, String>{

	Country findByCountryCode(String countryCode);

	Country findAllById(String id);

	

}
