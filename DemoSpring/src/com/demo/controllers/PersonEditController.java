package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.PersonDao;
import com.demo.dom.Person;


@Controller
@RequestMapping("/person")
public class PersonEditController {
	
    @Autowired PersonDao personDao;
    
    /** called before displaying the form */
    @RequestMapping(value={"/create"})    // Accepts url starting with "/person/create"
    public String createPerson(){
        return "/personedit";  // JSP containing the form.
    } 
    
    @RequestMapping(value={"/editsubmit"}) // Accepts url starting with "/person/editsubmit"
    public String addperson(@ModelAttribute Person person){  // Spring MVC will instantiate a new Person and automatically calls the setters to from the form fields.
        personDao.persist(person);  // We should verify that the user did not entry silly values before doing that but ... it's just a quick demo.
        return "redirect:/person";  // We have finished the edit -> we show the list of persons.
    }     
}
