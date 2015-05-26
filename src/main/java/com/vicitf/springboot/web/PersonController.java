package com.vicitf.springboot.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vicitf.springboot.domain.secondary.Person;
import com.vicitf.springboot.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	private Log log = LogFactory.getLog(getClass()); 
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/save")
	public Person save(Person p) {
		return personService.save(p);
	}
	
	@RequestMapping("/foo")
	public String foo() {
		log.error("Server Error: foo");
		throw new IllegalArgumentException("Server Error: foo");
	}
	
	@RequestMapping("/findById/{id}")
	public Person findById(@PathVariable Long id){
		return personService.findById(1L);
	}
	
	@RequestMapping("/findAll")
	public Page<Person> findAll(int number, int size) {
		return personService.findAll(new PageRequest(number, size));
	}
	
	@RequestMapping("/findByName")
	public List<Person> findByName(String name) {
		return personService.findByName(name);
	}
	
	@RequestMapping("/findByEmail")
	public List<Person> findByEmail(String email) {
		return personService.findByEmail(email);
	}
}