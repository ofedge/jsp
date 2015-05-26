package com.vicitf.springboot.repository.secondary.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vicitf.springboot.domain.secondary.Person;

public class CountryRepositoryImpl {
	@Autowired
	@Qualifier("secondaryEntityManagerFactory")
	private EntityManager entityManager;
	
	/**
	 * 即使条件是=的时候, countryName大小写好像也无所谓
	 * 
	 * @param countryName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Person> findPersonsInCountry(String countryName) {
		String hql = "select p from Person p, Country c where p.countryId = c.id and c.name like :countryName";
		Query query = entityManager.createQuery(hql);
		query.setParameter("countryName", "%" + countryName + "%");
		List<Person> list = query.getResultList();
		return list;
	}
}
