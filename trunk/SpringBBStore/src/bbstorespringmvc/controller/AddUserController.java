package bbstorespringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bbstorespringmvc.model.User;
import bbstorespringmvc.repository.UserRepository;


@Controller
public class AddUserController {

	@Autowired MenuController menu;
	@Autowired UserRepository userDao;
	
	@RequestMapping("/addUser")
	public ModelAndView addUser(@ModelAttribute User usr)
	{
		ModelAndView mv = new ModelAndView("adduser");
		mv.addObject("listRole",User.Role.values());
		userDao.persist(usr);
		return mv;		
	}
	
	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute User usr)
	{
		userDao.merge(usr);
		return "forward:/index";
	}
	
}
