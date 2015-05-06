package com.vicitf.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicitf.springboot.domain.Person;
import com.vicitf.springboot.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	public Person findById(Long id) {
		return personRepository.findById(id);
	}
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
}
