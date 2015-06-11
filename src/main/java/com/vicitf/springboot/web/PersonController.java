package com.vicitf.springboot.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vicitf.springboot.bean.PersonBean;
import com.vicitf.springboot.domain.secondary.Person;
import com.vicitf.springboot.param.CommonParam;
import com.vicitf.springboot.param.PageParam;
import com.vicitf.springboot.param.PageVo;
import com.vicitf.springboot.param.PropertyVo;
import com.vicitf.springboot.param.PropertyVo.Condition;
import com.vicitf.springboot.param.SortVo;
import com.vicitf.springboot.param.SortVo.DirectionVo;
import com.vicitf.springboot.param.SortVo.OrderVo;
import com.vicitf.springboot.service.PersonService;
import com.vicitf.springboot.utils.StringUtils;

@RestController
@RequestMapping("/person")
public class PersonController extends BaseController {

	@Autowired
	private PersonService personService;

	@RequestMapping("/save")
	public Person save(Person p) {
		return personService.save(p);
	}

	@RequestMapping("/foo")
	public String foo() {
		log.error("Server Error: foo");
		throw new IllegalArgumentException("Server Error: foo");
	}

	@RequestMapping("/findById/{id}")
	public Person findById(@PathVariable Long id) {
		return personService.findById(id);
	}

	@RequestMapping("/findAll")
	public Page<Person> findAll(int number, int size) {
		return personService.findAll(new PageRequest(number, size));
	}

	@RequestMapping("/findByName")
	public List<Person> findByName(String name) {
		return personService.findByName(name);
	}

	@RequestMapping("/findByEmail")
	public List<Person> findByEmail(String email) {
		return personService.findByEmail(email);
	}
	
	@RequestMapping("/findAllPerson")
	public PageVo<PersonBean> findAllPerson(int number, int size, String property, String order){
		List<PropertyVo> param = null;
		if (StringUtils.isNotNull(property)) {
			String[] propertiesArray = property.split(CommonParam.DEFAULT_REGEX);
			if (propertiesArray.length % 3 != 0) {
				log.error("页面参数错误");
				throw new IllegalArgumentException("页面参数错误");
			}
			if (propertiesArray.length > 0) {
				param = new ArrayList<PropertyVo>();
				for (int i = 0; i < propertiesArray.length; i += 3) {
					if (Condition.EQUAL.toString().equals(propertiesArray[i + 1])) {
						param.add(new PropertyVo(propertiesArray[i], propertiesArray[i + 2], Condition.EQUAL));
					} else if (Condition.LIKE.toString().equals(propertiesArray[i + 1])) {
						param.add(new PropertyVo(propertiesArray[i], propertiesArray[i + 2], Condition.LIKE));
					} else if (Condition.MORE_THAN.toString().equals(propertiesArray[i + 1])) {
						param.add(new PropertyVo(propertiesArray[i], propertiesArray[i + 2], Condition.MORE_THAN));
					} else if (Condition.MORE_OR_EQUAL.toString().equals(propertiesArray[i + 1])) {
						param.add(new PropertyVo(propertiesArray[i], propertiesArray[i + 2], Condition.MORE_OR_EQUAL));
					} else if (Condition.LESS_THAN.toString().equals(propertiesArray[i + 1])) {
						param.add(new PropertyVo(propertiesArray[i], propertiesArray[i + 2], Condition.LESS_THAN));
					} else if (Condition.LESS_OR_EQUAL.toString().equals(propertiesArray[i + 1])) {
						param.add(new PropertyVo(propertiesArray[i], propertiesArray[i + 2], Condition.LESS_OR_EQUAL));
					}
				}
			}
			
		}
		List<OrderVo> orders = null;
		if (StringUtils.isNotNull(order)) {
			String[] orderArray = order.split(CommonParam.DEFAULT_REGEX);
			if (orderArray.length % 2 != 0) {
				log.error("页面参数错误");
				throw new IllegalArgumentException("页面参数错误");
			}
			if (orderArray.length > 0) {
				orders = new ArrayList<OrderVo>();
				for (int i = 0; i < orderArray.length; i += 2) {
					if (DirectionVo.DESC.toString().equals(orderArray[i + 1])) {
						orders.add(new OrderVo(orderArray[i], DirectionVo.DESC));
					} else {
						orders.add(new OrderVo(orderArray[i]));
					}
				}
			}
		}
		SortVo sort = orders == null ? null : new SortVo(orders);
		PageParam pageParam = new PageParam(number, size, param, sort);
		return personService.findAllPerson(pageParam);
	}
	
	@RequestMapping(value = "/updatePerson", method = RequestMethod.POST)
	@ResponseBody
	public boolean updatePerson(Person person) {
		return personService.updatePerson(person);
	}
}