package bbstorespringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bbstorespringmvc.model.Book;
import bbstorespringmvc.repository.AuthorDao;
import bbstorespringmvc.repository.BookDao;


@Controller
public class AddBookController {
    @Autowired    BookDao bookDao;
    @Autowired    AuthorDao authorDao;
	@Autowired 	  MenuController menu;
    
    @RequestMapping(value={"/createbook"})
    public ModelAndView createNewBookForm(){
        ModelAndView mv = new ModelAndView( "addbook");
        mv.addObject("listAuthor",authorDao.getAllAuthors());
        return mv;
    } 
    
    @RequestMapping(value={"/addbook"})
    public ModelAndView addBook(@ModelAttribute Book bk, @RequestParam("idAuthor") long authorid){
        bk.setAuthor(authorDao.find(authorid));
        bookDao.persist(bk);
        return menu.redirectMenu(); 
    } 
}
