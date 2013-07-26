package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dom.Person;


@Controller
public class IndexController{
	Person person;


	@RequestMapping("/")
	public ModelAndView showIndex(){
		return new ModelAndView("index","person", person);
	} 

}
