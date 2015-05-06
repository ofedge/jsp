package com.vicitf.springboot.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vicitf.springboot.domain.Person;
import com.vicitf.springboot.service.PersonService;

@Controller
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/person")
	public String person(Map<String, Object> model){
		Person p = personService.findById(1L);
		model.put("person", p);
		return "person";
	}
	
	@RequestMapping("/persons")
	public String persons(Map<String, Object> model) {
		model.put("persons", personService.findAll());
		return "persons";
	}
}