package bbstorespringmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bbstorespringmvc.model.Book;
import bbstorespringmvc.repository.BookRepository;

@Controller
@RequestMapping("/book")
public class BookDisplayController extends BaseController {  // By convention here, we name the controller that display something XxxxDisplayController (and the JSP xxxdisplay.jsp) => it's not "BookDetailController".

	@Autowired BookRepository bookRepository;
	
	public ModelAndView displayBook(@RequestParam("id") long id) {  // We could use isbn insead, but Book inherits from BaseEntity now and gets an .id field from it.
		Book book = (Book)getRequiredEntity(id, Book.class);
		return new ModelAndView("bookdisplay", // JSP name.
				"book", book);  // Attribute attached to the request (model).
	}
}
