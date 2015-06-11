package com.vicitf.springboot.service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.springboot.ApplicationTest;
import com.vicitf.springboot.bean.CountryBean;
import com.vicitf.springboot.domain.secondary.Country;
import com.vicitf.springboot.domain.secondary.Person;
import com.vicitf.springboot.repository.secondary.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationTest.class)
public class CountryServiceTest {
	
	@Autowired
	private CountryRepository cr;
	
	@Test
	public void findAllTest() {
		List<Country> list = cr.findAll();
		for (Country c : list) {
			System.out.println(c);
		}
	}
	
	@Test
	public void findPersonsInCountryTest() {
		List<Person> list = cr.findPersonsInCountry("chi");
		for (Person p : list) {
			System.out.println(p);
		}
	}
	
	@Test
	public void findCountryBeanTest() {
		List<CountryBean> list = cr.findCountryBean();
		for (CountryBean c : list) {
			System.out.println(c);
		}
	}
}
