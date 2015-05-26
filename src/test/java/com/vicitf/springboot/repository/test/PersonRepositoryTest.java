package com.vicitf.springboot.repository.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.springboot.Application;
import com.vicitf.springboot.domain.secondary.Person;
import com.vicitf.springboot.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PersonRepositoryTest {
	@Autowired
	private PersonService pr;
	
	@Test
	public void findByIdTest() {
		Person p = pr.findById(1L);
		System.out.println(p);
	}
	
	@Test
	public void findAllTest() {
//		Page<Person> page = pr.findAll(new PageRequest(0, 10));
//		Page<Person> page = pr.findAll(new PageRequest(0, 10, Direction.ASC, "age", "id"));
//		Page<Person> page = pr.findAll(new PageRequest(0, 10, new Sort(Direction.ASC, "age", "id")));
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order(Direction.ASC, "age"));
		orderList.add(new Order(Direction.ASC, "id"));
		Page<Person> page = pr.findAll(new PageRequest(0, 10, new Sort(orderList)));
		System.out.println("numbers : " + page.getNumber());
		System.out.println("number of elements : " + page.getNumberOfElements());
		System.out.println("size : " + page.getSize());
		System.out.println("total elements : " + page.getTotalElements());
		System.out.println("total pages : " + page.getTotalPages());
		System.out.println("sort : " + page.getSort());
		System.out.println("is first: " + page.isFirst());
		System.out.println("is last: " + page.isLast());
		System.out.println("has content : " + page.hasContent());
		List<Person> list = page.getContent();
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
