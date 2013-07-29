package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/** Entry point, thanks to the request mapping "/" */

@Controller
public class IndexController{
	@RequestMapping("/")
	public String showIndex(){
		return "index";  // JSP
	} 

}
