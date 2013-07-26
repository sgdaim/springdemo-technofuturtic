package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.dao.PersonDao;


@Controller
public class AddPersonController {
	
    @Autowired PersonDao personDao;
    
    @RequestMapping(value={"/createPerson"})
    public String createPerson(){
        return "addperson";
    } 

}
