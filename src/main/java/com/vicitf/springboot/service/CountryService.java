package com.vicitf.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vicitf.springboot.domain.secondary.Country;
import com.vicitf.springboot.domain.secondary.Person;

public interface CountryService {
	
	Page<Country> findAll(Pageable pageable);
	
	List<Person> findPersonsInCountry(String countryName);
}
