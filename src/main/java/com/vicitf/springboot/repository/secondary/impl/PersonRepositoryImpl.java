package com.vicitf.springboot.repository.secondary.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vicitf.springboot.bean.PersonBean;

/**
 * 自定义Repository, 在对应repository后加上impl作为实现类名, 但不用继承对应的repository
 * 
 * @author vicitf
 *
 */
public class PersonRepositoryImpl {
	
	@Autowired
	@Qualifier("secondaryEntityManagerFactory")
	private EntityManager entityManager;
	
	/**
	 * PersonRepository中findAllPersonsWithCountry()方法的实现类
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PersonBean> findAllPersonsWithCountry() {
		String sql = "select p.name, p.email, p.age, p.gender, c.name \"country\" from t_person p, t_country c where p.country_id = c.id";
		Query query = entityManager.createNativeQuery(sql);
		query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(PersonBean.class));
		List<PersonBean> list = query.getResultList();
		return list;
	}
}
