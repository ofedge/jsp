package com.vicitf.springboot.repository.secondary.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vicitf.springboot.bean.PersonBean;
import com.vicitf.springboot.param.PageParam;
import com.vicitf.springboot.param.PageVo;
import com.vicitf.springboot.param.PropertyVo;
import com.vicitf.springboot.param.SortVo.OrderVo;

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
	
	/**
	 * 计数
	 * 
	 * @param pageParam
	 * @return
	 */
	public Long countAllPerson(PageParam pageParam) {
		StringBuffer sbSql = new StringBuffer();
		String sql = "";
		sbSql.append(" select count(1) from t_person p, t_country c where p.country_id = c.id");
		if (pageParam.getParam() != null) {
			for (int i = 1; i <= pageParam.getParam().size(); i++) {
				PropertyVo propertyVo = pageParam.getParam().get(i - 1);
				sbSql.append(" and " + propertyVo.getKey() + " " + propertyVo.getCondition().toString() + " ?" + i);
			}
		}
		if (pageParam.getSort() != null) {
			sbSql.append(" order by");
			for (OrderVo order : pageParam.getSort().getOrders()) {
				sbSql.append(" " + order.getProperty() + " " + order.getDirection() + ",");
			}
			sql = sbSql.substring(0, sbSql.length() - 1);
		} else {
			sql = sbSql.toString();
		}
		Query query = entityManager.createNativeQuery(sql);
		if (pageParam.getParam() != null) {
			for (int i = 1; i <= pageParam.getParam().size(); i++) {
				PropertyVo propertyVo = pageParam.getParam().get(i - 1);
				query.setParameter(i, propertyVo.getValue());
			}
		}
		Object obj = query.getSingleResult();
		return obj == null ? 0L : Long.valueOf(obj.toString());
	}
	
	/**
	 * @see com.vicitf.springboot.repository.secondary.PersonRepository.findAllPerson(PageParam)
	 */
	@SuppressWarnings("unchecked")
	public PageVo<PersonBean> findAllPerson(PageParam pageParam) {
		PageVo<PersonBean> vo = new PageVo<PersonBean>(pageParam.getPage(), pageParam.getNums());
		StringBuffer sbSql = new StringBuffer();
		String sql = "";
		sbSql.append(" select p.id \"id\", p.name \"name\", p.email \"email\", p.age \"age\", p.gender \"gender\", c.name \"country\" from t_person p, t_country c where p.country_id = c.id");
		if (pageParam.getParam() != null) {
			for (int i = 1; i <= pageParam.getParam().size(); i++) {
				PropertyVo propertyVo = pageParam.getParam().get(i - 1);
				sbSql.append(" and " + propertyVo.getKey() + " " + propertyVo.getCondition().toString() + " ?" + i);
			}
		}
		if (pageParam.getSort() != null) {
			vo.setSort(pageParam.getSort());
			sbSql.append(" order by");
			for (OrderVo order : pageParam.getSort().getOrders()) {
				sbSql.append(" " + order.getProperty() + " " + order.getDirection() + ",");
			}
			sql = sbSql.substring(0, sbSql.length() - 1);
		} else {
			sql = sbSql.toString();
		}
		Query query = entityManager.createNativeQuery(sql);
		if (pageParam.getParam() != null) {
			for (int i = 1; i <= pageParam.getParam().size(); i++) {
				PropertyVo propertyVo = pageParam.getParam().get(i - 1);
				query.setParameter(i, propertyVo.getValue());
			}
		}
		Long totalElements = this.countAllPerson(pageParam);
		vo.setTotalElements(totalElements);
		query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(PersonBean.class));
		query.setFirstResult(pageParam.getPage() * pageParam.getNums());
		query.setMaxResults(pageParam.getNums());
		List<PersonBean> content = query.getResultList();
		vo.setContent(content);
		vo.setNumberOfElements(content.size());
		long totalPage = totalElements % pageParam.getNums() == 0 ? totalElements / pageParam.getNums() : totalElements / pageParam.getNums() + 1;
		vo.setFirst(pageParam.getPage() == 0 || totalPage == 0L);
		vo.setLast(pageParam.getPage() + 1 == totalPage || totalPage == 0L);
		vo.setTotalPages(Integer.valueOf(String.valueOf(totalPage)));
		return vo;
	}
}
