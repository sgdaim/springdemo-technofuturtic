package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.PersonDao;
import com.demo.dom.Person;


@Controller
public class ListPersonController {
	 @Autowired    PersonDao personDao;
	 
	 @RequestMapping(value="/listperson")
	    public ModelAndView viewList(){
	        List<Person> lp = personDao.getAllPerson();
	        
	        return new ModelAndView("listperson",   // JSP
	        		                "persons", lp);  // Attribute attached to the request
	    } 

}
