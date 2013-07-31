package bbstorespringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bbstorespringmvc.model.Book;
import bbstorespringmvc.repository.BookRepository;


@Controller
@RequestMapping("/book")
public class BookEditController extends BaseController {

    @Autowired    BookRepository bookRepository;

    // Called before displaying the form (in case we want to create a book)
    @RequestMapping("/create")
    public ModelAndView bookCreate(){
        return prepareModelAndView(new Book());  // That book has no .id (null) because it has not been persisted yet.
    }

    // Called before displaying the form (in case we want to edit an existing book).
    @RequestMapping("/edit")
    public ModelAndView bookEdit(@RequestParam("id") long id){
        Book book = (Book)getRequiredEntity(id, Book.class);
        return prepareModelAndView(book);
    }	

    // Just a small method to prevent copy/pasting the code.
    private ModelAndView prepareModelAndView(Book book ) {
        ModelAndView mv = new ModelAndView("bookedit");  // JSP
        mv.addObject("id", book.getId());  // Will be null in case of create.
        mv.addObject("book", book); 
        return mv; 
    }

//    // Called when the user sumbits the form (previously done by BookEdit2Servlet)
//    @RequestMapping("/editsubmit")
//    public ModelAndView bookEditSubmit(@Valid @ModelAttribute Book book, BindingResult result){
//       
//        if (result.hasErrors()) { // If spring has detected validation errors, we redisplay the form.
//            return new ModelAndView ("bookedit", "book", book);
//        }
//
//        // We manually check that no other book has the same ISBN (Spring cannot automatically validate this kind of things).
//        Book bookHavingThatIsbn = (Book) bookRepository.findByIsbn(book.getIsbn());
//
//        if (book.getId() == null) { // New book instance (not from DB)
//            if(bookHavingThatIsbn != null) {
//            	return otherBookError(bookHavingThatIsbn);
//            }
//            bookRepository.persist(book);
//
//        } else {  // Edited book instance.
//            if(bookHavingThatIsbn != null && !book.equals(bookHavingThatIsbn)) {
//            	return otherBookError(bookHavingThatIsbn);
//            }
//            bookRepository.merge(book);
//        }
//        return new ModelAndView ("redirect:/book/"+book.getUrl());//redirect from book display
//    }
//    
//    private ModelAndView otherBookError(Book otherBook) {
//        ModelAndView mv = new ModelAndView ("bookedit", "book", book);
//        NotificationUtil.addNotificationMessage("Un autre livre utilise déjà cette abrévation '" + book.getAbrev() + "'");
//        return mv;
//    }
//    
//    
//    @RequestMapping ("/remove")
//    public ModelAndView removeBook(@RequestParam("id") Long id){
//    	Book book = (Book)getRequiredEntity(id, Book.class);
//        bookRepository.remove(book);
//    
//        return new ModelAndView ("redirect:/book");
//    }
//
//
//    @ModelAttribute
//    public Book findBook(@RequestParam(value ="id", required = false) Long id) {
//        if (id == null){ //create
//            return new Book();
//        } else { //edit
//            return getRequiredDetachedEntity(id);
//        }
//    }

        
}
