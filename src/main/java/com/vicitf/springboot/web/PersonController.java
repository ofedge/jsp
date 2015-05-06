package com.vicitf.springboot.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String person(){
		return "person";
	}
	
	@RequestMapping("/findById/{id}")
	@ResponseBody
	public Person findById(@PathVariable Long id){
		return personService.findById(1L);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Person> findAll(Map<String, Object> model) {
		return personService.findAll();
	}
	
	@RequestMapping("/findByName")
	@ResponseBody
	public List<Person> findByName(String name) {
		return personService.findByName(name);
	}
	
	@RequestMapping("/findByEmail")
	@ResponseBody
	public List<Person> findByEmail(String email) {
		return personService.findByEmail(email);
	}
}