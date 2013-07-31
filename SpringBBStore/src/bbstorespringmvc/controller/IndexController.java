package bbstorespringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bbstorespringmvc.model.ShoppingBasket;



@Controller
public class IndexController{
    @Autowired    ShoppingBasket shoppingBasket;
  
 
    @RequestMapping("/")
    public ModelAndView showIndex(){
        return new ModelAndView("index","shoppingBasket",shoppingBasket);
    } 
       
}
