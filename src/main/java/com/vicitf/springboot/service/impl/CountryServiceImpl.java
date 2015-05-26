package com.vicitf.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vicitf.springboot.domain.secondary.Country;
import com.vicitf.springboot.domain.secondary.Person;
import com.vicitf.springboot.repository.secondary.CountryRepository;
import com.vicitf.springboot.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Page<Country> findAll(Pageable pageable) {
		return countryRepository.findAll(pageable);
	}

	@Override
	public List<Person> findPersonsInCountry(String countryName) {
		return countryRepository.findPersonsInCountry(countryName);
	}

}
