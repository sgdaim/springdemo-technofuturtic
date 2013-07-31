package bbstorespringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import bbstorespringmvc.repository.UserDao;

@Controller
public class UserListController {
	@Autowired UserDao userDao;
	
	@RequestMapping("/viewUserlist")
	public ModelAndView viewUserList()
	{
		ModelAndView mv = new ModelAndView("listuser");
		mv.addObject("userList",userDao.findAllUsers());
		return mv;
	}

}
