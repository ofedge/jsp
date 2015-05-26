package com.vicitf.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vicitf.springboot.domain.secondary.Person;

public interface PersonService {

	Person save(Person p);

	Person findById(Long id);

	Page<Person> findAll(Pageable pageable);

	List<Person> findByName(String name);

	List<Person> findByEmail(String email);

}