package com.vicitf.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vicitf.springboot.domain.secondary.Person;
import com.vicitf.springboot.repository.PersonRepository;

@Service
public class PersonService {
	public static final String FIND_ALL = "findAll";
	public static final String PERSON_KEY = "\"personKey\""; // 为什么要双引号才行
	
	@Autowired
	private PersonRepository personRepository;
	
	@CacheEvict(value = FIND_ALL, key = PERSON_KEY) // 清除缓存
	public Person save(Person p) {
		return personRepository.save(p);
	}
	
	public Person findById(Long id) {
		return personRepository.findById(id);
	}
	
	@Cacheable(value = FIND_ALL, key = PERSON_KEY) // value值为ehcache.xml中制定的name值
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public List<Person> findByName(String name) {
		return personRepository.findByName(name);
	}
	
	public List<Person> findByEmail(String email) {
		return personRepository.findByEmail(email);
	}
}
