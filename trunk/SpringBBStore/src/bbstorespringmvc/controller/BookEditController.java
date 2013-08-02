package bbstorespringmvc.controller;

import javax.validation.Valid;

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
public class BookEditController extends BaseController {

    @Autowired    BookRepository bookRepository;

    // Called before displaying the form (in case we want to create a book)
    @RequestMapping("/bookcreate")
    public ModelAndView bookCreate(){
        return prepareModelAndView(new Book());  // That book has no .id (null) because it has not been persisted yet.
    }

    // Called before displaying the form (in case we want to edit an existing book).
    @RequestMapping("/bookedit")
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

    // Called when the user sumbits the form (previously done by BookEdit2Servlet)
    @RequestMapping("/bookeditsubmit")
    public ModelAndView bookEditSubmit(@Valid @ModelAttribute Book book, BindingResult bindingResult){
       
    	// Spring can automatically detect some validation problems, according to the annotations on the entity.
        if (bindingResult.hasErrors()) { // If spring has detected validation errors, we redisplay the form.
            return new ModelAndView ("bookedit", "book", book);
        }

        // We manually check that no other book has the same ISBN (Spring cannot automatically validate this kind of things).
        Book bookHavingThatIsbn = (Book) bookRepository.findByIsbn(book.getIsbn());

        if (book.getId() == null) { // New book instance (not from DB)
            if(bookHavingThatIsbn != null) {
            	return otherBookError(book, bookHavingThatIsbn, bindingResult);
            }
            bookRepository.persist(book);

        } else {  // Edited book instance.
            if(bookHavingThatIsbn != null && !book.equals(bookHavingThatIsbn)) {
            	return otherBookError(book, bookHavingThatIsbn, bindingResult);
            }
            bookRepository.merge(book);  // needed because book is detached (=> no automatic dirty checking).
        }
        
        return new ModelAndView ("redirect:/book?id="+book.getId());  // no error => redirect to book display
    }
    
    private ModelAndView otherBookError(Book book, Book otherBook, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView ("bookedit", "book", book);
        bindingResult.rejectValue("isbn", "", "Un autre livre utilise déjà cet ISBN '" + book.getIsbn() + "'");
        System.out.println("Un autre livre utilise déjà cet ISBN '" + book.getIsbn() + "'");
        return mv;
    }
    
    


    // This method (not easy to understand) is called by Spring, before calling the bookEditSubmit method.
    // bookEditSumbit() has a parameter Book annotated  @ModelAttribute. By default, Spring would do new Book(), fill it with the form fields and give it to the bookEditSumbit method as parameter.
    // But if we let Spring do new Book(), then that book is not an entity bound to Hibernate.
    // Instead, we would like Spring to call em.find(id, Book.class) to get the edited book from hibernate before it injects the form values into the entity's fields.
    // This findBook method enables us to do that: because it is annotated @ModelAttribute, Spring will call it to get a book instead of doing new Book().
    // If the form has been used to create a new book, there is no id and we do new Book() ourselves (and in bookEditSubmit, we'll do an em.persist(book)).
    // If the form has boon used to edit an existing book, we get this existing book from Hibernate (and in bookEditSubmit, we'll do an am.merge(book)).
    // In the edit case, we return a detached entity to avoir auto-saving with dirty checking. Indeed, if the entity was managed (not detached), it would be saved at the end by the OpenEntityManagerInViewFilter. But if there is a validation error (a mistake from the user in the field) we don't want to save. Having the entity detached enables us to need an explicit save (em.merge(book)).
    // See http://feima2011.wordpress.com/2011/01/23/restful-in-spring-3/
    //     http://blog.netapsys.fr/index.php/post/2011/12/30/Spring-MVC-Formulaire-et-validation
    @ModelAttribute
    public Book findBook(@RequestParam(value ="id", required = false) Long id) {
        if (id == null){ //create
            return new Book();
        } else { //edit
            return (Book)getRequiredDetachedEntity(id, Book.class);
        }
    }


}
