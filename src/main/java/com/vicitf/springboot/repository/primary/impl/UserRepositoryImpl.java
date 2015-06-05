package com.vicitf.springboot.repository.primary.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class UserRepositoryImpl {
	@Autowired
	@Qualifier("primaryEntityManagerFactory")
	private EntityManager entityManager;
	
	public Integer existsByUsername(String username){
		String hql = "select count(1) from User u where u.username = :username";
		Query query = entityManager.createQuery(hql);
		query.setParameter("username", username);
		Object obj = query.getSingleResult();
		return obj == null ? 0 : Integer.valueOf(obj.toString());
	};
}
