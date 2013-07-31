package bbstorespringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController{
 
    @RequestMapping("/")
    public String showIndex(){
        return "index"; // JSP (this controller is not doing anything useful but giving access to the JSP).
    } 
       
}
