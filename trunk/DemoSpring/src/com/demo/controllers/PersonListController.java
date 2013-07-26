package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.PersonDao;
import com.demo.dom.Person;

@Controller
@RequestMapping("/person")
public class PersonListController {

	@Autowired PersonDao personDao;

	@RequestMapping(method=RequestMethod.GET)   // Matches all the get request for "/person" (except "/person/something..." defined in PersonEditController class).
	public ModelAndView viewList() {
		List<Person> lp = personDao.getAllPerson();

		return new ModelAndView("personlist", // JSP
				"persons", lp); // Attribute attached to the request
	}

}
