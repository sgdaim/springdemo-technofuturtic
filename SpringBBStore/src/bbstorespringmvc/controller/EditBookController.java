package bbstorespringmvc.controller;

import org.springframework.stereotype.Controller;


@Controller
public class EditBookController {

//    @Autowired    BookRepository bookDao;
//    @Autowired    AuthorDao authorDao;
//    @Autowired    ListBookController listBookController;
//
//    @RequestMapping(value={"/editbook"})
//    public ModelAndView editBook(@ModelAttribute Book bk){
//        ModelAndView mv = new ModelAndView("editbook");
//        mv.addObject( "book",bk);
//        mv.addObject( "listAuthor",authorDao.getAllAuthors());
//        return mv;
//    }
//    
//    @RequestMapping(value={"/updatebook"})
//    public ModelAndView updateBook(@ModelAttribute Book bk){
//        bookDao.merge(bk);
//        return listBookController.viewList(true);
//    }
//
//    @ModelAttribute
//    public Book findBook(@RequestParam("id")Long id ,@RequestParam(value="author.id", required = false) Long idAuthor){
//        Book result = bookDao.find(id);
//        if(idAuthor !=null)
//        {
//        result.setAuthor(authorDao.find(idAuthor));
//        }
//        return  result;
//    }
//    
}
