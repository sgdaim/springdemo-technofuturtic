package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.PersonDao;
import com.demo.dom.Person;


@Controller
public class AddPersonController {
	
    @Autowired PersonDao personDao;
    Person person;
    
    @RequestMapping(value={"/createPerson"})
    public String createPerson(){
        return "addperson";
    } 
    @RequestMapping(value={"/addPerson"})
    public ModelAndView addperson( @ModelAttribute Person person){

        personDao.persist(person);
        return this.redirectList();
    }     
    public ModelAndView redirectList(){
        return new ModelAndView("listPerson");
    } 
}
