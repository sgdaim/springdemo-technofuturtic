package bbstorespringmvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bbstorespringmvc.model.Book;
import bbstorespringmvc.model.User;
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class UserDao extends BaseRepository<User> {
	
	public  List<Book> findAllUsers(){
        return em.createQuery("select u from User u").getResultList();
    }

}
