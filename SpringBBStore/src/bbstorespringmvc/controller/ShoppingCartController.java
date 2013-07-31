package bbstorespringmvc.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bbstorespringmvc.model.Book;
import bbstorespringmvc.model.ShoppingCart;
import bbstorespringmvc.repository.BookRepository;

@Controller
public class ShoppingCartController extends BaseController {  // By convention here, we name the controller that display something XxxxDisplayController (and the JSP xxxdisplay.jsp) => it's not "BookDetailController".

	@Autowired BookRepository bookRepository;
	
	@RequestMapping("/addbooktocart")
	public ModelAndView addBookToCart(@RequestParam("bookidtoadd") long bookIdToAdd, // We could use isbn insead, but Book inherits from BaseEntity now and gets an .id field from it.
			 HttpSession session) {  // The HttpSession is automatically provided by Spring if we specify it as parameter. 
		Book book = (Book)getRequiredEntity(bookIdToAdd, Book.class);
		
		ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("ShoppingCart");

		synchronized(session) {  
			if (shoppingCart == null) {
				shoppingCart = new ShoppingCart();
				session.setAttribute("ShoppingCart", shoppingCart);
			}
		}
		
		return new ModelAndView("bookaddtocartconfirm", // JSP name.
				"book", book);  // Attribute attached to the request (model).
	}
}
