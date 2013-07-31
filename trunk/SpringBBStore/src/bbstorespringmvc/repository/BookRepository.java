package bbstorespringmvc.repository;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bbstorespringmvc.model.Book;


@Repository
@Transactional
@SuppressWarnings("unchecked")  // Many queries need a cast (to List<Book>, for example) to be formal, but it would not be so nice in the code.
public class BookRepository extends BaseRepository<Book>{
    
    public  List<Book> findAllByTitle(){
        return em.createQuery("select b from Book b order by b.title").getResultList();
    }
    
}
