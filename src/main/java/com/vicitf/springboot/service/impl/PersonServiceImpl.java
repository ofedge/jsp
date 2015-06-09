package com.vicitf.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vicitf.springboot.bean.PersonBean;
import com.vicitf.springboot.domain.secondary.Person;
import com.vicitf.springboot.param.PageParam;
import com.vicitf.springboot.param.PageVo;
import com.vicitf.springboot.repository.secondary.PersonRepository;
import com.vicitf.springboot.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
//	public static final String FIND_ALL = "findAll";
//	public static final String PERSON_KEY = "\"personKey\""; // 为什么要双引号才行
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
//	@CacheEvict(value = FIND_ALL, key = PERSON_KEY) // 清除缓存
	public Person save(Person p) {
		return personRepository.save(p);
	}
	
	@Override
	public Person findById(Long id) {
		return personRepository.findById(id);
	}
	
	@Override
//	@Cacheable(value = FIND_ALL, key = PERSON_KEY) // value值为ehcache.xml中制定的name值
	public Page<Person> findAll(Pageable pageable) {
		return personRepository.findAll(pageable);
	}
	
	@Override
	public List<Person> findByName(String name) {
		return personRepository.findByName(name);
	}
	
	@Override
	public List<Person> findByEmail(String email) {
		return personRepository.findByEmail(email);
	}

	@Override
	public List<PersonBean> findAllPersonsWithCountry() {
		return personRepository.findAllPersonsWithCountry();
	}

	@Override
	public PageVo<PersonBean> findAllPerson(PageParam pageParam) {
		return personRepository.findAllPerson(pageParam);
	}

	@Override
	@Transactional("secondaryTransactionManager")
	public boolean updatePerson(Person person) {
		return personRepository.updatePerson(person.getName(), person.getEmail(), person.getAge(), person.getGender(), person.getCountryId(), person.getId()) > 0;
	}
}
