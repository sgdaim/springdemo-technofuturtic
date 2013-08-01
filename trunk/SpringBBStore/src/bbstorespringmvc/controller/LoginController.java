package bbstorespringmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @RequestMapping("/loginform")
    public String loginform(){
        return "login";
    }	
    
    @RequestMapping("/loginsubmit")
    public String loginSubmit(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
    	if (password.length() < 5) {  // Not successful
    		return "login";
    	} else {  // Success
    		session.setAttribute("username", username);
    		return "redirect:/";
    	}
    }
}
