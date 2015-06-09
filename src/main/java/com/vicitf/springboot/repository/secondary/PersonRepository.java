package com.vicitf.springboot.repository.secondary;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vicitf.springboot.bean.PersonBean;
import com.vicitf.springboot.domain.secondary.Person;
import com.vicitf.springboot.param.PageParam;
import com.vicitf.springboot.param.PageVo;

/**
 * 好神奇...
 * 
 * @author vicitf
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#save(S)
	 */
	@SuppressWarnings("unchecked")
	Person save(Person p);
	
	/**
	 * 根据id获取
	 * 
	 * @param id
	 * @return
	 */
	Person findById(Long id);
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 * 被最后一个方法取代
	 */
	Page<Person> findAll(Pageable pageable);
	
	/**
	 * 被最后一个方法取代
	 * 
	 * @param name
	 * @return
	 */
	@Query("select p from Person p where p.name like %?1%")
	List<Person> findByName(String name);
	
	/**
	 * 被最后一个方法取代
	 * 
	 * @param email
	 * @return
	 */
	@Query(value = "SELECT * FROM t_person P WHERE P.EMAIL LIKE %:email%", nativeQuery = true)
	List<Person> findByEmail(@Param("email") String email);
	
	/**
	 * 页面上没用到, 当做demo放着吧
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
	
	/**
	 * @param name
	 * @param email
	 * @param age
	 * @param gender
	 * @param countryId
	 * @param id
	 * @return
	 */
	@Modifying
	@Query(value = "update Person p set p.name = ?1, p.email = ?2, p.age = ?3, p.gender = ?4, p.countryId = ?5 where p.id = ?6")
	int updatePerson(String name, String email, Integer age, String gender, Long countryId, Long id);
}