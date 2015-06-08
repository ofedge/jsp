package com.vicitf.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vicitf.springboot.bean.PersonBean;
import com.vicitf.springboot.domain.secondary.Person;
import com.vicitf.springboot.param.PageParam;
import com.vicitf.springboot.param.PageVo;

public interface PersonService {

	/**
	 * 保存方法
	 * 
	 * @param p
	 * @return
	 */
	Person save(Person p);

	/**
	 * 根据id查询方法
	 * 
	 * @param id
	 * @return
	 */
	Person findById(Long id);

	/**
	 * 不用了
	 * 
	 * @param pageable
	 * @return
	 */
	Page<Person> findAll(Pageable pageable);

	/**
	 * 不用了
	 * 
	 * @param name
	 * @return
	 */
	List<Person> findByName(String name);

	/**
	 * 不用了
	 * 
	 * @param email
	 * @return
	 */
	List<Person> findByEmail(String email);

	/**
	 * 没用过
	 * 
	 * @return
	 */
	List<PersonBean> findAllPersonsWithCountry();
	
	/**
	 * 根据条件查询
	 * 
	 * @param pageParam
	 * @return
	 */
	PageVo<PersonBean> findAllPerson(PageParam pageParam);
}