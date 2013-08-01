package bbstorespringmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bbstorespringmvc.model.Book;
import bbstorespringmvc.repository.BookRepository;

@Controller
public class BookListController extends BaseController {

	@Autowired BookRepository bookRepository;

	@RequestMapping("/booklist")
	public ModelAndView showBookList(){
		ModelAndView mv = new ModelAndView("booklist");   // JSP
		List<Book> list = bookRepository.findAllByTitle();
		mv.addObject("bookList", list);  // attached to the request. 
		return mv;
	}
	
	/** Creates a few books in the DB */
	@RequestMapping("/bookcreatetestdata")
	public String createTestBooks() {
		Book b1 = new Book("12345", "Springo Fantastico", "John Rizzo", 10);
		Book b2 = new Book("22345", "Javablabla", "John Rizzo", 20);
		Book b3 = new Book("33345", "The World is ...", "John Doe", 30);

		bookRepository.persist(b1);
		bookRepository.persist(b2);
		bookRepository.persist(b3);
		
		return "redirect:/booklist";  // display the list again. We ask the browser to send a new HTTP request to /book, and we'll go through the controller putting the list of books in the request (in the ModelAndView) for the JSP.
	}
}
