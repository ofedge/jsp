package com.vicitf.springboot.repository.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.springboot.Application;
import com.vicitf.springboot.domain.secondary.Person;
import com.vicitf.springboot.repository.PersonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PersonRepositoryTest {
	@Autowired
	private PersonRepository pr;
	
	@Test
	public void findByIdTest() {
		Person p = pr.findById(1L);
		System.out.println(p);
	}
	
	@Test
	public void findAllTest() {
		List<Person> list = pr.findAll();
		for (Person p : list) {
			System.out.println(p);
		}
	}
	
	@Test
	public void findByName() {
		List<Person> list = pr.findByName("jon");
		for (Person p : list) {
			System.out.println(p);
		}
	}
	
	@Test
	public void findByEmail() {
		List<Person> list = pr.findByEmail("jon@gmail.com");
		for (Person p : list) {
			System.out.println(p);
		}
	}
}
