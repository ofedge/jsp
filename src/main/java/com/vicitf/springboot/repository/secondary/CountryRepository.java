package com.vicitf.springboot.repository.secondary;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vicitf.springboot.domain.secondary.Country;
import com.vicitf.springboot.domain.secondary.Person;

public interface CountryRepository extends JpaRepository<Country, Long> {
	
	Page<Country> findAll(Pageable pageable);
	
	List<Person> findPersonsInCountry(String countryName);
}
