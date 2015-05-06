package com.vicitf.springboot.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.vicitf.springboot.domain.Person;

/**
 * 好神奇...
 * 
 * @author vicitf
 *
 */
public interface PersonRepository extends Repository<Person, Long> {
	Person findById(Long id);
	List<Person> findAll();
}
