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
	
	@RequestMapping("/shoppingcartadd")
	public ModelAndView shoppingCartAdd(@RequestParam("bookidtoadd") long bookIdToAdd, // We could use isbn insead, but Book inherits from BaseEntity now and gets an .id field from it.
			 HttpSession session) {  // The HttpSession is automatically provided by Spring if we specify it as parameter. 
		Book book = (Book)getRequiredEntity(bookIdToAdd, Book.class);
		
		ShoppingCart shoppingCart = getCartFromSessionOrCreate(session);
		shoppingCart.add(book);
		
		return new ModelAndView("shoppingcartaddconfirm", // JSP name.
				"book", book);  // Attribute attached to the request (model).
	}
	
	
	@RequestMapping("/shoppingcartdisplay")
	public String shoppingcartdisplay( HttpSession session) {  // The HttpSession is automatically provided by Spring if we specify it as parameter. 
		getCartFromSessionOrCreate(session); // We make sure that the cart exists, but we don't need it in this method. The JSP will need it and will find if in the session from ${shoppingCart}
		
		return "shoppingcartdisplay"; // JSP name.
	}

	
	@RequestMapping ("/shoppingcartremove")
    public ModelAndView shoppingCartRemove(@RequestParam("id") Long id){
    	Book book = (Book)getRequiredEntity(id, Book.class);
        bookRepository.remove(book);
    
        return new ModelAndView ("redirect:/booklist");
    }


	private ShoppingCart getCartFromSessionOrCreate(HttpSession session) {
		ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");

		synchronized(session) {  
			if (shoppingCart == null) {
				shoppingCart = new ShoppingCart();
				session.setAttribute("shoppingCart", shoppingCart);
			}
		}
		
		return shoppingCart;
	}
}
