package com.vicitf.springboot.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vicitf.springboot.domain.Person;
import com.vicitf.springboot.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/save")
	public Person save(Person p) {
		return personService.save(p);
	}
	
	@RequestMapping("/foo")
	public String foo() {
		throw new IllegalArgumentException("server error");
	}
	
	@RequestMapping("/findById/{id}")
	public Person findById(@PathVariable Long id){
		return personService.findById(1L);
	}
	
	@RequestMapping("/findAll")
	public List<Person> findAll(Map<String, Object> model) {
		return personService.findAll();
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