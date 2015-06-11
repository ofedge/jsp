package com.vicitf.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vicitf.springboot.bean.CountryBean;
import com.vicitf.springboot.domain.secondary.Country;
import com.vicitf.springboot.domain.secondary.Person;
import com.vicitf.springboot.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController extends BaseController {
	@Autowired
	private CountryService countryService;

	@RequestMapping("/findAll")
	public Page<Country> findAll(int number, int size) {
		return countryService.findAll(new PageRequest(number, size));
	}

	@RequestMapping("/findByCountryname/{countryName}")
	public List<Person> findPersonsInCountry(@PathVariable String countryName) {
		return countryService.findPersonsInCountry(countryName);
	}
	
	@RequestMapping("/findCountryBean")
	public List<CountryBean> findCountryBean(){
		return countryService.findCountryBean();
	}
}
